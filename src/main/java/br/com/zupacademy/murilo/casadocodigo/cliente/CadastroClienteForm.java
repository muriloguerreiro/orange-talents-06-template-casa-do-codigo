package br.com.zupacademy.murilo.casadocodigo.cliente;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.murilo.casadocodigo.estado.Estado;
import br.com.zupacademy.murilo.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.murilo.casadocodigo.pais.Pais;
import br.com.zupacademy.murilo.casadocodigo.pais.PaisRepository;
import br.com.zupacademy.murilo.casadocodigo.validacao.anotacao.CpfCnpj;
import br.com.zupacademy.murilo.casadocodigo.validacao.anotacao.Existe;
import br.com.zupacademy.murilo.casadocodigo.validacao.anotacao.ValorUnico;

public class CadastroClienteForm {

	@NotBlank
	@Email
	@ValorUnico(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CpfCnpj
	@NotBlank
	@ValorUnico(domainClass = Cliente.class, fieldName = "documento")
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@Existe(domainClass = Pais.class, fieldName = "id")
	private Long pais_id;

	private Long estado_id;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public CadastroClienteForm(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long pais_id, Long estado_id, @NotBlank String telefone,
			@NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais_id = pais_id;
		this.estado_id = estado_id;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getPais_id() {
		return pais_id;
	}

	public Long getEstado_id() {
		return estado_id;
	}
	
	/**
	 * Método que converte os dados recebidos para a classe Cliente.
	 * @param email é obrigatório e deve estar no formato de email.
	 * @param nome é obrigatório.
	 * @param sobrenome é obrigatório.
	 * @param documento é obrigatório, deve ser único e um CPF ou CNPJ válido.
	 * @param endereco é obrigatório.
	 * @param complemento é obrigatório.
	 * @param cidade é obrigatório.
	 * @param pais não pode ser nulo e deve existir no banco.
	 * @param estado é obrigatorio se o pais contém ao menos um estado.
	 * @param telefone é obrigatório.
	 * @param cep é obrigatório.
	 */

	public Cliente converter(PaisRepository paisRepo, EstadoRepository estadoRepo) {
		Optional<Pais> buscaPais = paisRepo.findById(pais_id);

		Pais pais = buscaPais.get();

		Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);

		if (estado_id != null) {
			Optional<Estado> buscaEstado = estadoRepo.findById(estado_id);
			cliente.setEstado(buscaEstado.get());
		}

		return cliente;
	}

}
