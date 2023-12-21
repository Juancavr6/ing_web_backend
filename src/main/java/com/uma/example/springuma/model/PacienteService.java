package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    RepositoryPaciente repositoryPaciente;
    @Autowired
    RepositoryPerfilSalud repositoryPerfilSalud;

    public List<Paciente> getAllPacientes(){
        return repositoryPaciente.findAll();
    }

    public Paciente getPaciente(Long id){
        return repositoryPaciente.getReferenceById(id);
    }
    public Paciente getPaciente(String dni){
        return repositoryPaciente.findByDni(dni);
    }

    public List<Paciente> getPacienteByMedico(long id ){
        return repositoryPaciente.findByMedicoId(id);
    }

    public Paciente addPaciente(Paciente c){
        return repositoryPaciente.saveAndFlush(c);
    }

    public void updatePacienteParametros(PerfilSalud p){

        repositoryPerfilSalud.save(p);
    }
    public void updatePaciente(Paciente c){
        repositoryPaciente.save(c);
    }

    public void updatePacienteName(long id,String name){
        Paciente p = repositoryPaciente.getReferenceById(id);
        p.setNombre(name);
        repositoryPaciente.save(p);
    }

    public void removePaciente(Paciente c){
        repositoryPaciente.delete(c);
    }

    public void removePacienteID(Long id){
        repositoryPaciente.deleteById(id);
    }
}
