package com.uma.example.springuma.model;

import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public long getId() {
        return id;
    }
    public Evento(){}

    private String nombre;
    private String descripcion;  
    private LocalDateTime fecha; 
    
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


}