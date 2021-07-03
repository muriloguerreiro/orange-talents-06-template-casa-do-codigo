package br.com.zupacademy.murilo.casadocodigo.livro.cadastro;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.murilo.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.murilo.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.murilo.casadocodigo.livro.Livro;
import br.com.zupacademy.murilo.casadocodigo.livro.LivroRepository;

@RestController
public class CadastroLivroController {

	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping("/livros")
	@Transactional
	public ResponseEntity<CadastroLivroDto> cadastrar(@RequestBody @Valid CadastroLivroForm livroForm) {
			Livro livro = livroForm.converter(categoriaRepository, autorRepository);
			livroRepository.save(livro);
			
		return ResponseEntity.ok(new CadastroLivroDto(livro));
	}
	
	
}
