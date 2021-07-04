package br.com.zupacademy.murilo.casadocodigo.livro.cadastro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.murilo.casadocodigo.autor.Autor;
import br.com.zupacademy.murilo.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.murilo.casadocodigo.categoria.Categoria;
import br.com.zupacademy.murilo.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.murilo.casadocodigo.livro.Livro;
import br.com.zupacademy.murilo.casadocodigo.validacao.Existe;
import br.com.zupacademy.murilo.casadocodigo.validacao.ValorUnico;

public class CadastroLivroForm {
	
	@NotBlank
	@ValorUnico(domainClass = Livro.class, fieldName = "titulo" )
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	@Column
	private String sumario;
	
	@NotNull
	@Min(20)
	private BigDecimal preco;
	
	@NotNull
	@Min(100)
	private Integer paginas;
	
	@NotBlank
	@ValorUnico(domainClass = Livro.class, fieldName = "isbn" )
	private String isbn;
	
	@Future
	@JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	@Existe(domainClass = Categoria.class, fieldName = "id")
	private Long categoria_id;
	
	@NotNull
	@Existe(domainClass = Autor.class, fieldName = "id")
	private Long autor_id;
	
	@JsonCreator
	public CadastroLivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer paginas, @NotBlank String isbn,
			@Future LocalDate dataPublicacao, @NotNull Long categoria_id, @NotNull Long autor_id) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria_id = categoria_id;
		this.autor_id = autor_id;
	}
	
	/**
	 * Método que converte os dados recebidos para a classe Livro.
	 * @param titulo deve ser obrigatório e único. 
	 * @param resumo deve ser obrigatório e ter no máximo 500 caracteres.
	 * @param sumario tem formato livre.
	 * @param preco deve ser obrigatório e ter um valor mínimo de 20.
	 * @param paginas deve ser obrigatório e ter um valor mínimo de 100.
	 * @param isbn deve ser obrigatório e único.
	 * @param dataPublicacao deve ser futura.
	 * @param categoria não pode ser nula.
	 * @param autor não pode ser nulo.
	 */
	
	public Livro converter(CategoriaRepository categoriaRepo, AutorRepository autorRepo) {
		Optional<Autor> buscaAutor = autorRepo.findById(autor_id);
		Optional<Categoria> buscaCategoria = categoriaRepo.findById(categoria_id);
		
		Autor autor = buscaAutor.get();
		Categoria categoria = buscaCategoria.get();
			
		return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataPublicacao, categoria, autor);
	}	
	
}
