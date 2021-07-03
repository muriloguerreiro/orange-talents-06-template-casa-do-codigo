package br.com.zupacademy.murilo.casadocodigo.livro.detalhe;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.murilo.casadocodigo.livro.Livro;
import br.com.zupacademy.murilo.casadocodigo.livro.LivroRepository;

@RestController
public class DetalheLivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping("/livros/{id}")
	public ResponseEntity<DetalheLivroDto> detalhar(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		
		if (livro.isPresent()) {
			DetalheLivroDto livroDto = new DetalheLivroDto(livro.get());
			return ResponseEntity.ok(livroDto);
		}
		
		return ResponseEntity.notFound().build();
	}
}
