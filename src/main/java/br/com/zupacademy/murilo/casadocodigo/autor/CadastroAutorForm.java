package br.com.zupacademy.murilo.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastroAutorForm {

	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public CadastroAutorForm(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	/**
	 * Método que converte os dados recebidos para a classe Autor.
	 * @param email é obrigatório e deve estar no formato de email.
	 * @param nome é obrigatório.
	 * @param descricao é obrigatório e deve ter comprimento máximo de 400 caracteres.
	 */

	public Autor converter() {
		return new Autor(email, nome, descricao);
	}

}
