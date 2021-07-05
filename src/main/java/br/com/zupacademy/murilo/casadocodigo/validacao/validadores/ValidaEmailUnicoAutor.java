package br.com.zupacademy.murilo.casadocodigo.validacao.validadores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.murilo.casadocodigo.autor.Autor;
import br.com.zupacademy.murilo.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.murilo.casadocodigo.autor.CadastroAutorForm;

@Component
public class ValidaEmailUnicoAutor implements Validator {

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CadastroAutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CadastroAutorForm autorForm = (CadastroAutorForm) target;
		
		Optional<Autor> autor = autorRepository.findByEmail(autorForm.getEmail());
		
		if (autor.isPresent()) {
			errors.rejectValue("email", null, "Já existe um(a) autor(a) com o email " + autorForm.getEmail());
		}
	}
	

}
