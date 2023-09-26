package com.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}