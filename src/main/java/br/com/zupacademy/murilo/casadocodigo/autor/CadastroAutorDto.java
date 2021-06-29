package br.com.zupacademy.murilo.casadocodigo.autor;

public class CadastroAutorDto {

	private String email;
	private String nome;
	private String descricao;

	public CadastroAutorDto(Autor autor) {
		this.email = autor.getEmail();
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
