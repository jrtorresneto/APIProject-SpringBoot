package com.kidopilabs.com.br.teste.controller.converter;

import com.kidopilabs.com.br.teste.controller.data.request.PacienteRequest;
import com.kidopilabs.com.br.teste.controller.data.response.PacienteResponse;
import com.kidopilabs.com.br.teste.entity.PacienteEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteConverter {

    public List<PacienteResponse> convertEntityToList(final List<PacienteEntity> pacientes) {
        List<PacienteResponse> responses = new ArrayList<>();

        pacientes.forEach(paciente -> {
            PacienteResponse response = new PacienteResponse.Builder()
                    .id(String.valueOf(paciente.getId()))
                    .nome(paciente.getNome())
                    .idade(String.valueOf(paciente.getIdade()))
                    .sexo(String.valueOf(paciente.getSexo()))
                    .build();

            responses.add(response);
        });

        return responses;
    }

    public PacienteResponse convertEntityToResponse(final PacienteEntity paciente) {
        return new PacienteResponse.Builder()
                .id(String.valueOf(paciente.getId()))
                .nome(paciente.getNome())
                .idade(String.valueOf(paciente.getIdade()))
                .sexo(String.valueOf(paciente.getSexo()))
                .build();
    }

    public PacienteEntity convertRequestToEntity(final PacienteRequest request) {
        final PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setIdade(Integer.parseInt(request.getIdade()));
        pacienteEntity.setNome(request.getNome());
        pacienteEntity.setSexo(Integer.parseInt(request.getSexo()));
        return pacienteEntity;
    }

}
