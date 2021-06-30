package br.com.zupacademy.murilo.casadocodigo.categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.murilo.casadocodigo.validacao.ValidaNomeUnicoCategoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ValidaNomeUnicoCategoria validaNomeUnicoCategoria;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validaNomeUnicoCategoria);
	}

	@PostMapping
	public ResponseEntity<CadastroCategoriaDto> cadastrar(@RequestBody @Valid CadastroCategoriaForm categoriaForm) {
		
		Categoria categoria = categoriaForm.converter();
		categoriaRepository.save(categoria);
		
		return ResponseEntity.ok(new CadastroCategoriaDto(categoria));
	}
}
