package com.kidopilabs.com.br.teste.controller;

import com.kidopilabs.com.br.teste.controller.converter.PacienteConverter;
import com.kidopilabs.com.br.teste.controller.data.request.PacienteRequest;
import com.kidopilabs.com.br.teste.controller.data.response.PacienteResponse;
import com.kidopilabs.com.br.teste.entity.PacienteEntity;
import com.kidopilabs.com.br.teste.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/pacientes/")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteConverter pacienteConverter;

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> listarTodos() {
        final List<PacienteEntity> pacientes = this.pacienteService.listar();
        final List<PacienteResponse> responseList = this.pacienteConverter.convertEntityToList(pacientes);
        if (CollectionUtils.isEmpty(responseList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(responseList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> buscarPorId(@PathVariable Long id) {
        final Optional<PacienteEntity> paciente = this.pacienteService.buscarPorId(id);
        if (paciente.isPresent()) {
            final PacienteResponse response = this.pacienteConverter.convertEntityToResponse(paciente.get());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/buscar/{nome}")
    public ResponseEntity<List<PacienteResponse>> listalistarPorNomerTodos(@PathVariable String nome) {
        final List<PacienteEntity> pacientes = this.pacienteService.listarPorNome(nome);
        final List<PacienteResponse> responseList = this.pacienteConverter.convertEntityToList(pacientes);
        if (CollectionUtils.isEmpty(responseList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(responseList);
        }
    }

    @PostMapping("/adicionar/")
    public ResponseEntity<PacienteResponse> adicionarPaciente(@RequestBody @Valid PacienteRequest request) {
        final PacienteEntity paciente = this.pacienteConverter.convertRequestToEntity(request);
        final PacienteEntity pacienteNew = this.pacienteService.adicionar(paciente);

        PacienteResponse response = this.pacienteConverter.convertEntityToResponse(pacienteNew);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
