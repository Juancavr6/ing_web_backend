package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnfermedadService {

    @Autowired
    RepositoryEnfermedad repositoryEnfermedad;

    public List<Enfermedad> getAllEnfermedads(){
        return repositoryEnfermedad.findAll();
    }

    public Enfermedad getEnfermedad(Long id){
        return repositoryEnfermedad.getReferenceById(id);
    }

    public Enfermedad addEnfermedad(Enfermedad c){
        return repositoryEnfermedad.saveAndFlush(c);
    }

    public void updateEnfermedad(Enfermedad c){
        repositoryEnfermedad.save(c);
    }

    public void removeEnfermedad(Enfermedad c){
        repositoryEnfermedad.delete(c);
    }

    public void removeEnfermedadID(Long id){
        repositoryEnfermedad.deleteById(id);
    }
}
