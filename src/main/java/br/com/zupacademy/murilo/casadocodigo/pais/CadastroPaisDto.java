package br.com.zupacademy.murilo.casadocodigo.pais;

public class CadastroPaisDto {
	
	private String nome;

	public CadastroPaisDto(Pais pais) {
		this.nome = pais.getNome();
	}

	public String getNome() {
		return nome;
	}
	
}
