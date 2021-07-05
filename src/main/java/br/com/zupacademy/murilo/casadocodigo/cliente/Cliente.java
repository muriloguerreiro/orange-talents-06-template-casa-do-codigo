package br.com.zupacademy.murilo.casadocodigo.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.murilo.casadocodigo.estado.Estado;
import br.com.zupacademy.murilo.casadocodigo.pais.Pais;
import br.com.zupacademy.murilo.casadocodigo.validacao.anotacao.CpfCnpj;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CpfCnpj
	@NotBlank
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@ManyToOne
	private Pais pais;

	@ManyToOne
	private Estado estado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;
	
	@Deprecated
	public Cliente() {
	}

	public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank Pais pais, @NotBlank String telefone, @NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
