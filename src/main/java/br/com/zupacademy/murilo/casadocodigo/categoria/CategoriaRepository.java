package br.com.zupacademy.murilo.casadocodigo.categoria;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{

	Optional<Categoria> findByNome(String nome);

}
