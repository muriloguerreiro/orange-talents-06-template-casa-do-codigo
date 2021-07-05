package br.com.zupacademy.murilo.casadocodigo.estado;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.murilo.casadocodigo.pais.Pais;
import br.com.zupacademy.murilo.casadocodigo.pais.PaisRepository;
import br.com.zupacademy.murilo.casadocodigo.validacao.anotacao.Existe;
import br.com.zupacademy.murilo.casadocodigo.validacao.anotacao.ValorUnico;

public class CadastroEstadoForm {

	@NotBlank
	@ValorUnico(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	@NotNull
	@Existe(domainClass = Pais.class, fieldName = "id")
	private Long pais_id;

	public CadastroEstadoForm(@NotBlank String nome, @NotNull Long pais_id) {
		this.nome = nome;
		this.pais_id = pais_id;
	}

	public String getNome() {
		return nome;
	}

	/**
	 * Método que converte os dados recebidos para a classe Estado.
	 * 
	 * @param nome deve ser obrigatório e único para o país informado.
	 * @param pais não pode ser nulo.
	 */

	public Estado converter(PaisRepository paisRepo) {
		Optional<Pais> buscaPais = paisRepo.findById(pais_id);

		Pais pais = buscaPais.get();

		return new Estado(nome, pais);
	}

}
