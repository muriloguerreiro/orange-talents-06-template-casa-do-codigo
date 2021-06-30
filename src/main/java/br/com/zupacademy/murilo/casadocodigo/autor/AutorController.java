package br.com.zupacademy.murilo.casadocodigo.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.murilo.casadocodigo.validacao.ValidaEmailUnicoAutor;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private ValidaEmailUnicoAutor validaEmailUnicoAutor;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validaEmailUnicoAutor);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CadastroAutorDto> cadastrar(@RequestBody @Valid CadastroAutorForm autorForm) {
		Autor autor = autorForm.converter();
		autorRepository.save(autor);
		
		return ResponseEntity.ok(new CadastroAutorDto(autor));
	}
	
}
