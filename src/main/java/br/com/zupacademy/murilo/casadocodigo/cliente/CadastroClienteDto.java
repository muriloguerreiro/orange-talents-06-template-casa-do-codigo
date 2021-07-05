package br.com.zupacademy.murilo.casadocodigo.cliente;

public class CadastroClienteDto {

	private Long id;

	public Long getId() {
		return id;
	}

	public CadastroClienteDto(Cliente cliente) {
		this.id = cliente.getId();
	}

}
