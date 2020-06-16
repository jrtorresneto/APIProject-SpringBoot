package com.kidopilabs.com.br.teste.service;

import com.kidopilabs.com.br.teste.entity.PacienteEntity;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    PacienteEntity adicionar(PacienteEntity paciente);

    List<PacienteEntity> listar();

    Optional<PacienteEntity> buscarPorId(Long id);

    List<PacienteEntity> listarPorNome(String nome);

}
