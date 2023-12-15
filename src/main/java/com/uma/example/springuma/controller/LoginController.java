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
public class LoginController {
    
@Autowired
    private PacienteService pacienteService;
@Autowired
    private MedicoService medicoService;

    @GetMapping("login/paciente")
    public int getLoginPaciente(){
        return 0;
    }
    @GetMapping("login/medico")
    public int getLoginMedico(){
        return 1;
    }

    @GetMapping("login/medos")
    public int getLoginDos(){
        return 2;
    }

    @GetMapping("login/paciente/{id}")
    public String getCodePaciente(@PathVariable("id") Long id) {
        return pacienteService.getPaciente(id).getCodigo();
    }
    @GetMapping("login/medico/{id}")
    public String getCodeMedico(@PathVariable("id") Long id) {
        return medicoService.getMedico(id).getCodigo();
    }
    
}