package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEvento extends JpaRepository<Evento, Long>{
    List<Evento> findByPacienteId(long id);
}
