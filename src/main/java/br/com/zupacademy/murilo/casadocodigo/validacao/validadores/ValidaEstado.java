package br.com.zupacademy.murilo.casadocodigo.validacao.validadores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.murilo.casadocodigo.cliente.CadastroClienteForm;

@Component
public class ValidaEstado implements Validator {

	@Autowired
	private EntityManager manager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CadastroClienteForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CadastroClienteForm clienteForm = (CadastroClienteForm) target;
		Long idEstado = clienteForm.getEstado_id();
		Long idPais = clienteForm.getPais_id();
		
		/**
		 * Valida se País não possui estados e o id do Estado não é informado.
		 */
		
		Query query1 = manager.createQuery("select l from Estado l where pais_id = :pPais");
		query1.setParameter("pPais", idPais);
		List<?> list1 = query1.getResultList();
		
		if (list1.isEmpty() && idEstado == null) {
			return;
		} else if (idEstado == null) {
			Assert.state(idEstado != null, "O país informado contém estados. Por favor, escolha um!");
		}
		
		/**
		 * Valida se o Estado informado pertence ao País referenciado.
		 */
		
		Query query2 = manager.createQuery("select l from Estado l where id = :pEstado and pais_id = :pPais");
		query2.setParameter("pEstado", idEstado);
		query2.setParameter("pPais", idPais);
		List<?> list2 = query2.getResultList();
		Assert.state(list2.size() > 0, "O estado não pertence ao país informado");
		
		return;
	}
	
}
