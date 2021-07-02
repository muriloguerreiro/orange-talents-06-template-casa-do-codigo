package br.com.zupacademy.murilo.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CadastroLivroDto {
	
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer paginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private String nomeCategoria;
	private String nomeAutor;
	
	public CadastroLivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.nomeCategoria = livro.getCategoria().getNome();
		this.nomeAutor = livro.getAutor().getNome();
	}
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public String getNomeAutor() {
		return nomeAutor;
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
	
}
