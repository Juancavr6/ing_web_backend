package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    RepositoryPaciente repositoryPaciente;

    public List<Paciente> getAllPacientes(){
        return repositoryPaciente.findAll();
    }

    public Paciente getPaciente(Long id){
        return repositoryPaciente.getReferenceById(id);
    }
    public Paciente getPaciente(String dni){
        return repositoryPaciente.findByDni(dni);
    }

    public Paciente addPaciente(Paciente c){
        return repositoryPaciente.saveAndFlush(c);
    }

    public void updatePaciente(Paciente c){
        repositoryPaciente.save(c);
    }

    public void removePaciente(Paciente c){
        repositoryPaciente.delete(c);
    }

    public void removePacienteID(Long id){
        repositoryPaciente.deleteById(id);
    }
}
