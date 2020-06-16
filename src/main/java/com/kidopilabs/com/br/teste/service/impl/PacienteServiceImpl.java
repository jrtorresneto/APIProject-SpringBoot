package com.kidopilabs.com.br.teste.service.impl;

import com.kidopilabs.com.br.teste.entity.PacienteEntity;
import com.kidopilabs.com.br.teste.repository.PacienteRepository;
import com.kidopilabs.com.br.teste.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public PacienteEntity adicionar(PacienteEntity paciente) {
        return this.pacienteRepository.save(paciente);
    }

    @Override
    public List<PacienteEntity> listar() {
        return this.pacienteRepository.findAll();
    }

    @Override
    public Optional<PacienteEntity> buscarPorId(Long id) {
        if(Objects.isNull(id)) {
            throw new IllegalArgumentException("O parametro id não pode ser nulo ou vazio");
        }
        return this.pacienteRepository.findById(id);
    }

    @Override
    public List<PacienteEntity> listarPorNome(String nome) {
        if(StringUtils.isEmpty(nome)) {
            throw new IllegalArgumentException("O parametro nome não pode ser nulo ou vazio");
        }
        return this.pacienteRepository.findByNomeContains(nome);
    }

}
