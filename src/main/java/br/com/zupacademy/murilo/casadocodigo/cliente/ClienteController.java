package br.com.zupacademy.murilo.casadocodigo.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.murilo.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.murilo.casadocodigo.pais.PaisRepository;
import br.com.zupacademy.murilo.casadocodigo.validacao.validadores.ValidaEstado;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ValidaEstado validaEstado;
	
	@InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validaEstado);
    }
	
	@PostMapping("/clientes")
	public ResponseEntity<CadastroClienteDto> cadastrar(@RequestBody @Valid CadastroClienteForm clienteForm) {
		Cliente cliente = clienteForm.converter(paisRepository, estadoRepository);
		clienteRepository.save(cliente);
		
		return ResponseEntity.ok(new CadastroClienteDto(cliente));
	}
	
}
