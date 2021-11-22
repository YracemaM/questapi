package ar.com.ada.api.questinados.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.questinados.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Categoria findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    Categoria findById(int id);    
}
