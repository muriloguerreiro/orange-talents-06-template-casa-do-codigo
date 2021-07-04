package br.com.zupacademy.murilo.casadocodigo.pais;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.murilo.casadocodigo.validacao.ValorUnico;

public class CadastroPaisForm {

	@NotBlank
	@ValorUnico(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	@Deprecated
	public CadastroPaisForm() {
	}

	public CadastroPaisForm(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	/**
	 * Método que converte os dados recebidos para a classe Pais.
	 * 
	 * @param nome é obrigatório e deve ser único.
	 */

	public Pais converter() {
		return new Pais(nome);
	}

}
