package com.uma.example.springuma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PerfilSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public PerfilSalud(){}

    private float altura;
    private float peso;
    private int glucosa;
    private int frecuenciaCardiaca;
    private int presionSis;
    private int presionDia;
    private int colesterol;
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public int getGlucosa() {
        return glucosa;
    }
    public void setGlucosa(int glucosa) {
        this.glucosa = glucosa;
    }
    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }
    public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }
    public int getPresionSis() {
        return presionSis;
    }
    public void setPresionSis(int presionSis) {
        this.presionSis = presionSis;
    }
    public int getPresionDia() {
        return presionDia;
    }
    public void setPresionDia(int presionDia) {
        this.presionDia = presionDia;
    }
    public int getColesterol() {
        return colesterol;
    }
    public void setColesterol(int colesterol) {
        this.colesterol = colesterol;
    }
    
}