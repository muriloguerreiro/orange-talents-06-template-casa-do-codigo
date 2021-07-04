package br.com.zupacademy.murilo.casadocodigo.estado;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.murilo.casadocodigo.pais.PaisRepository;

@RestController
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping("/estados")
	@Transactional
	public ResponseEntity<CadastroEstadoDto> cadastrar(@RequestBody @Valid CadastroEstadoForm estadoForm) {
		
		Estado estado = estadoForm.converter(paisRepository);
		estadoRepository.save(estado);
		
		return ResponseEntity.ok(new CadastroEstadoDto(estado));
	}
	
	

}
