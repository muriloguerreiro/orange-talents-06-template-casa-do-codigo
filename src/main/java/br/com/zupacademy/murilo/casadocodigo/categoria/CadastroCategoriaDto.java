package br.com.zupacademy.murilo.casadocodigo.categoria;

public class CadastroCategoriaDto {

	private String nome;

	public CadastroCategoriaDto(Categoria categoria) {
		this.nome = categoria.getNome();
	}

	public String getNome() {
		return nome;
	}
}
