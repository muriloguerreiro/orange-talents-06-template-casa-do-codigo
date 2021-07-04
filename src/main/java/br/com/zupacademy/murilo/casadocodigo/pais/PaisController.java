package br.com.zupacademy.murilo.casadocodigo.pais;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping("/paises")
	@Transactional
	public ResponseEntity<CadastroPaisDto> cadastrar(@RequestBody @Valid CadastroPaisForm paisForm) {
		
		Pais pais = paisForm.converter();
		paisRepository.save(pais);
	
		return ResponseEntity.ok(new CadastroPaisDto(pais));
	}
}
