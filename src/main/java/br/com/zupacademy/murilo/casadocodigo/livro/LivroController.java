package br.com.zupacademy.murilo.casadocodigo.livro;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.murilo.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.murilo.casadocodigo.categoria.CategoriaRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CadastroLivroDto> cadastrar(@RequestBody @Valid CadastroLivroForm livroForm) {
			Livro livro = livroForm.converter(categoriaRepository, autorRepository);
			livroRepository.save(livro);
			
		return ResponseEntity.ok(new CadastroLivroDto(livro));
	}
}
