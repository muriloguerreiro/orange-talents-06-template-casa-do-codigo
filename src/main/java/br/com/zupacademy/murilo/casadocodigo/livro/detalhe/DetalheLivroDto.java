package br.com.zupacademy.murilo.casadocodigo.livro.detalhe;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zupacademy.murilo.casadocodigo.livro.Livro;

public class DetalheLivroDto {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer paginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private String nomeAutor;
	private String descricaoAutor;

	public DetalheLivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.nomeAutor = livro.getAutor().getNome();
		this.descricaoAutor = livro.getAutor().getDescricao();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getDescricaoAutor() {
		return descricaoAutor;
	}

}
