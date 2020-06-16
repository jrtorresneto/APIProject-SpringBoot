package com.kidopilabs.com.br.teste.repository;


import com.kidopilabs.com.br.teste.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

    Optional<PacienteEntity> findById(Long id);
    List<PacienteEntity> findByNomeContains(String nome);

}
