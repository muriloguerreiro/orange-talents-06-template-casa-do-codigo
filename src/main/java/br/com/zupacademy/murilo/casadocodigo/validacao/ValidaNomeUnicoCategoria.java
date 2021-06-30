package br.com.zupacademy.murilo.casadocodigo.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.murilo.casadocodigo.categoria.CadastroCategoriaForm;
import br.com.zupacademy.murilo.casadocodigo.categoria.Categoria;
import br.com.zupacademy.murilo.casadocodigo.categoria.CategoriaRepository;

@Component
public class ValidaNomeUnicoCategoria implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CadastroCategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		CadastroCategoriaForm categoriaForm = (CadastroCategoriaForm) target;
		
		Optional<Categoria> categoria = categoriaRepository.findByNome(categoriaForm.getNome());
		
		if (categoria.isPresent()) {
			errors.rejectValue("nome", null, "Já existe uma categoria com o nome " + categoriaForm.getNome());
		}
		
	}
	
}
