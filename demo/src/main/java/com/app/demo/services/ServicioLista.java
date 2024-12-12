package com.app.demo.services;

import com.app.demo.entities.Lista;
import com.app.demo.repositories.RepositorioLista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioLista {
    @Autowired
    private RepositorioLista repositorioLista;
    public void crear(Lista lista){
        repositorioLista.save(lista);
    }
    public boolean editar(Long id, Lista listaNueva){
        Optional<Lista> optionalLista = repositorioLista.findById(id);
        if (optionalLista.isPresent()) {
            Lista listaEdit = optionalLista.get();
            listaEdit.setFecha(listaNueva.getFecha());
            listaEdit.setNombre(listaNueva.getNombre());
            listaEdit.setPrioridad(listaNueva.getPrioridad());
            listaEdit.setFinalizada(listaNueva.isFinalizada());
            repositorioLista.save(listaEdit);

            return true;
        }
        return false;
    }


    public boolean editaEstado(Long id, boolean finalizada){
        Optional<Lista> optionalLista = repositorioLista.findById(id);
        if (optionalLista.isPresent()) {
          optionalLista.get().setFinalizada(finalizada);
          repositorioLista.save(optionalLista.get());

            return true;
        }
        return false;
    }


    public boolean eliminar(Long id){
        Optional<Lista> optionalLista = repositorioLista.findById(id);
        if (optionalLista.isPresent()) {
         repositorioLista.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Lista> mostrar(){
        return repositorioLista.findAll();
    }
}
