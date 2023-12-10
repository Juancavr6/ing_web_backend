package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    RepositoryMedico repositoryMedico;

    public List<Medico> getAllMedicos(){
        return repositoryMedico.findAll();
    }

    public Medico getMedico(Long id){
        return repositoryMedico.getReferenceById(id);
    }

    public Medico addMedico(Medico c){
        return repositoryMedico.saveAndFlush(c);
    }

    public void updateMedico(Medico c){
        repositoryMedico.save(c);
    }

    public void removeMedico(Medico c){
        repositoryMedico.delete(c);
    }

    public void removeMedicoID(Long id){
        repositoryMedico.deleteById(id);
    }
}
