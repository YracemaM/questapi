package ar.com.ada.api.questinados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questinados.entities.Categoria;
import ar.com.ada.api.questinados.repos.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

    public List<Categoria> traerCategorias() {
        return repo.findAll();
    }

    public Categoria buscarCategoriaPorId(Integer categoriaId) {
        
        Optional<Categoria> resultado = repo.findById(categoriaId);
        Categoria categoria = null;

        if(resultado.isPresent())
            categoria = resultado.get();
        
        return categoria;
    }

    /*public Categoria buscarCategoriaV2(Integer categoriaId) {

        Categoria categoria = repo.findById(categoriaId.intValue());

        return categoria;
    }*/

    public boolean crearCategoria(Categoria categoria) {
        
        if(existe(categoria.getNombre()))
            return false;

        repo.save(categoria);

        return true;
    }

    public boolean existePorId(int id) {

        Categoria categoria = repo.findById(id);
        return categoria != null;
    }

    public boolean existe(String nombre) {

        Categoria categoria = repo.findByNombre(nombre);
        return categoria != null;
    }

    /*public boolean existeV2(String nombre) {
        return repo.existsByNombre(nombre);
    }*/

    public boolean eliminarCategoriaPorId(Integer id) {

        boolean res = false;

        if(existePorId(id)) { 

            repo.deleteById(id);

            res = (!existePorId(id));
        }

        return res;  
    }
    
}
