package com.itsqmet.service;

import com.itsqmet.entity.Plato;
import com.itsqmet.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoService {
    @Autowired
    private PlatoRepository platoRepository;

    //Mostrar todos los platos
    public List<Plato> mostrarPlatos(){
        return platoRepository.findAll();
    }
    //Filtrar por Categoria
    public List<Plato> filtrarPorCategoria(String categoria){
        if (categoria==null||categoria.isEmpty()){
            return platoRepository.findAll();
        }else {
            return platoRepository.findByCategoriaContainingIgnoreCase(categoria);
        }
    }
    //Buscar por Id para eliminar y actualizar
    public Optional<Plato> buscarPorId(Long id){
        return platoRepository.findById(id);
    }
    //Guardar nuevo plato
    public Plato guardarPlato(Plato plato){
        return platoRepository.save(plato);
    }
    //Eliminar plato
    public void  eliminarPlato(Long id){
        platoRepository.deleteById(id);
    }
}
