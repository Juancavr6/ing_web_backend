package com.uma.example.springuma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uma.example.springuma.model.Enfermedad;
import com.uma.example.springuma.model.Evento;
import com.uma.example.springuma.model.Medico;
import com.uma.example.springuma.model.MedicoService;
import com.uma.example.springuma.model.Paciente;
import com.uma.example.springuma.model.PacienteService;

@RestController
public class UsuarioController {
    
@Autowired
    private PacienteService pacienteService;
@Autowired
    private MedicoService medicoService;

    @GetMapping("/paciente")
    public List<Paciente> getPacientes(){
        return pacienteService.getAllPacientes();
    }

    @GetMapping("/medico")
    public List<Medico> getMedicos(){
        return medicoService.getAllMedicos();
    }
    
    @GetMapping("/paciente/{id}")
    public Paciente getPaciente(@PathVariable("id") Long id) {
        return pacienteService.getPaciente(id);
    }
    @GetMapping("/paciente/{id}/eventos")
    public List<Evento> getPacienteEventos(@PathVariable("id") Long id) {
        return pacienteService.getPaciente(id).getEventos();
    }
    @GetMapping("/paciente/{id}/medico")
    public Medico getPacienteMedico(@PathVariable("id") Long id) {
        return pacienteService.getPaciente(id).getMedico();
    }
    @GetMapping("/paciente/{id}/enfermedades")
    public List<Enfermedad> getPacienteEnfermedades(@PathVariable("id") Long id) {
        return pacienteService.getPaciente(id).getEnfermedades();
    }
    @PostMapping(value = "/paciente",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> savePaciente(@RequestBody Paciente paciente) {
        try{
            pacienteService.addPaciente(paciente);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
	}
    @PostMapping(value = "/medico",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> savePaciente(@RequestBody Medico medico) {
        try{
            medicoService.addMedico(medico);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
	}

    @PutMapping(value = "/paciente",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> updatePaciente (@RequestBody Paciente paciente) {
        try{
            pacienteService.updatePaciente(paciente);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al actualizar la Paciente");
        }
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable("id") Long id) {
        try{
            pacienteService.removePacienteID(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al eliminar  Paciente");
        }
    }

    @DeleteMapping("/medico/{id}")
    public ResponseEntity<?> deleteMedico(@PathVariable("id") Long id) {
        try{
            medicoService.removeMedicoID(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
