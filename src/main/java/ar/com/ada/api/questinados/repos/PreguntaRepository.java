package ar.com.ada.api.questinados.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.questinados.entities.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
    
    Pregunta findById(int id);
    Pregunta findByEnunciado(String enunciado);
}
