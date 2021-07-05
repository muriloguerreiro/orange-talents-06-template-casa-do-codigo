package br.com.zupacademy.murilo.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.murilo.casadocodigo.validacao.anotacao.ValorUnico;

public class CadastroCategoriaForm {
	
	@NotBlank
	@ValorUnico(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	
	@Deprecated
	public CadastroCategoriaForm () {
		
	}
	public CadastroCategoriaForm (@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	/**
	 * Método que converte os dados recebidos para a classe Categoria.
	 * @param nome é obrigatório.
	 */

	public Categoria converter() {
		return new Categoria(nome);
	}
}
