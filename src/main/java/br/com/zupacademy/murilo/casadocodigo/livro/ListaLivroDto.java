package br.com.zupacademy.murilo.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

public class ListaLivroDto {
	
	private Long id;
	private String titulo;
	
	public ListaLivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	
	public static List<ListaLivroDto> converter(List<Livro> lista) {
		return lista.stream().map(ListaLivroDto::new).collect(Collectors.toList());
	}
}
