package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @Autowired
    RepositoryEvento repositoryEvento;

    public List<Evento> getAllEventos(){
        return repositoryEvento.findAll();
    }

    public Evento getEvento(Long id){
        return repositoryEvento.getReferenceById(id);
    }

    public List<Evento> getEventoByPaciente(long id ){
        return repositoryEvento.findByPacienteId(id);
    }

    public Evento addEvento(Evento c){
        return repositoryEvento.saveAndFlush(c);
    }

    public void updateEvento(Evento c){
        repositoryEvento.save(c);
    }

    public void removeEvento(Evento c){
        repositoryEvento.delete(c);
    }

    public void removeEventoID(Long id){
        repositoryEvento.deleteById(id);
    }
}

