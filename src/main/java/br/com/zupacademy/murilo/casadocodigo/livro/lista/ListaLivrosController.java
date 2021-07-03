package br.com.zupacademy.murilo.casadocodigo.livro.lista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.murilo.casadocodigo.livro.Livro;
import br.com.zupacademy.murilo.casadocodigo.livro.LivroRepository;

@RestController
public class ListaLivrosController {
	
	@Autowired
	private LivroRepository livroRepository;

	@GetMapping("/livros")
	public ResponseEntity<List<ListaLivroDto>> listar() {
		List<Livro> lista = livroRepository.findAll();
		
		List<ListaLivroDto> listaDto = ListaLivroDto.converter(lista);
		
		return ResponseEntity.ok(listaDto);
	}
}
