package br.com.zupacademy.murilo.casadocodigo.estado;

public class CadastroEstadoDto {

	private String nome;
	private String nomePais;
	
	public CadastroEstadoDto(Estado estado) {
		this.nome = estado.getNome();
		this.nomePais = estado.getPais().getNome();
	}

	public String getNome() {
		return nome;
	}

	public String getNomePais() {
		return nomePais;
	}	
	
}
