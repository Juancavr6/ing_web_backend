package com.uma.example.springuma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Paciente (){
        
    }

    private String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Column(unique=true)
    private String dni;
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }


    private int edad;
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @OneToOne
    private PerfilSalud parametros;
    public  PerfilSalud getParametros() {
        return parametros;
    }

    public void setParametros(PerfilSalud parametros) {
        this.parametros = parametros;
    }

    @OneToMany
    private Evento evento;
    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    @ManyToOne
    private Medico medico;
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}
    