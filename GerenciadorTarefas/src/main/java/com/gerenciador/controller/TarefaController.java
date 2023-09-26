package com.gerenciador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.entities.Tarefa;
import com.gerenciador.services.TarefaService;





@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	private final TarefaService tarefaService;

	@Autowired
	public TarefaController(TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> buscaTarefaControlId(@PathVariable Long id) {
		Tarefa tarefa = tarefaService.getTarefaById(id);
		if (tarefa != null) {
			return ResponseEntity.ok(tarefa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Tarefa>> buscaTodasTarefasControl() {
		List<Tarefa> tarefa = tarefaService.getAllTarefas();
		return ResponseEntity.ok(tarefa);
	}

	@PostMapping("/")
	public ResponseEntity<Tarefa> saveTarefaControl(@RequestBody Tarefa tarefa) {
		Tarefa saveTarefa = tarefaService.saveTarefa(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveTarefa);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Tarefa> alteraTarefaControl(@PathVariable Long id, @RequestBody Tarefa tarefa) {
		Tarefa alteraTarefa = tarefaService.changeTarefa(id, tarefa);

		if (alteraTarefa != null) {
			return ResponseEntity.ok(tarefa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTarefaControl(@PathVariable Long id) {
		boolean delete = tarefaService.deleteTarefa(id);
		if (delete) {
			return ResponseEntity.ok().body("O produto foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}