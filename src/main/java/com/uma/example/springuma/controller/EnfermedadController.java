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
import com.uma.example.springuma.model.EnfermedadService;
import com.uma.example.springuma.model.Evento;
import com.uma.example.springuma.model.Medico;
import com.uma.example.springuma.model.MedicoService;
import com.uma.example.springuma.model.Enfermedad;
import com.uma.example.springuma.model.EnfermedadService;

@RestController
public class EnfermedadController {
    
@Autowired
    private EnfermedadService enfermedadService;


    @GetMapping("/enfermedad")
    public List<Enfermedad> getEnfermedades(){
        return enfermedadService.getAllEnfermedads();
    }
    
    @GetMapping("/enfermedad/{id}")
    public Enfermedad getEnfermedad(@PathVariable("id") Long id) {
        return enfermedadService.getEnfermedad(id);
    }

    @PostMapping(value = "/enfermedad",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> saveEnfermedad(@RequestBody Enfermedad Enfermedad) {
        try{
            enfermedadService.addEnfermedad(Enfermedad);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
	}

    @PutMapping(value = "/enfermedad",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> updateEnfermedad (@RequestBody Enfermedad Enfermedad) {
        try{
            enfermedadService.updateEnfermedad(Enfermedad);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al actualizar la Enfermedad");
        }
    }

    @DeleteMapping("/enfermedad/{id}")
    public ResponseEntity<?> deleteEnfermedad(@PathVariable("id") Long id) {
        try{
            enfermedadService.removeEnfermedadID(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al eliminar  Enfermedad");
        }
    }

}