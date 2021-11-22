package ar.com.ada.api.questinados.models.request;

import java.util.List;

import ar.com.ada.api.questinados.entities.Respuesta;

public class InfoPreguntaNueva {

    public String enunciado;
    public List<Respuesta> opciones;
    public Integer categoriaId;    
}
