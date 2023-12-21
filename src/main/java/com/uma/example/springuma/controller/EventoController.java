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

import com.uma.example.springuma.model.Evento;
import com.uma.example.springuma.model.EventoService;
import com.uma.example.springuma.model.Evento;
import com.uma.example.springuma.model.Medico;
import com.uma.example.springuma.model.MedicoService;
import com.uma.example.springuma.model.Evento;
import com.uma.example.springuma.model.EventoService;

@RestController
public class EventoController {
    
@Autowired
    private EventoService eventoService;


    @GetMapping("/evento")
    public List<Evento> getEventos(){
        return eventoService.getAllEventos();
    }
    
    @GetMapping("/evento/{id}")
    public Evento getEvento(@PathVariable("id") Long id) {
        return eventoService.getEvento(id);
    }
    @GetMapping("/evento/paciente/{id}")
    public List<Evento> getEventosPaciente(@PathVariable("id") Long id) {
        return eventoService.getEventoByPaciente(id);
    }

    @PostMapping(value = "/evento",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> saveEvento(@RequestBody Evento Evento) {
        try{
            eventoService.addEvento(Evento);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
	}

    @PutMapping(value = "/evento",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> updateEvento (@RequestBody Evento Evento) {
        try{
            eventoService.updateEvento(Evento);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al actualizar la Evento");
        }
    }

    @DeleteMapping("/evento/{id}")
    public ResponseEntity<?> deleteEvento(@PathVariable("id") Long id) {
        try{
            eventoService.removeEventoID(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}