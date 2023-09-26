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

import com.gerenciador.entities.ItemExecucao;
import com.gerenciador.services.ItemExecucaoService;

@RestController
@RequestMapping("/itemExecucao")
public class ItemExecucaoController {

	private final ItemExecucaoService itemExecucaoService;

	@Autowired
	public ItemExecucaoController(ItemExecucaoService itemExecucaoService) {
		this.itemExecucaoService = itemExecucaoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemExecucao> buscaItemExecucaoControlId(@PathVariable Double percentual) {
		ItemExecucao itemExecucao = itemExecucaoService.getItemExecucaoByPercentual(percentual);
		if (itemExecucao != null) {
			return ResponseEntity.ok(itemExecucao);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<ItemExecucao>> buscaTodasItemExecucaoControl() {
		List<ItemExecucao> itemExecucao = itemExecucaoService.getAllItemExecucaos();
		return ResponseEntity.ok(itemExecucao);
	}

	@PostMapping("/")
	public ResponseEntity<ItemExecucao> saveItemExecucaoControl(@RequestBody ItemExecucao itemExecucao) {
		ItemExecucao saveItemExecucao = itemExecucaoService.saveItemExecucao(itemExecucao);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveItemExecucao);
	}

	@PostMapping("/{id}")
	public ResponseEntity<ItemExecucao> alteraItemExecucaoControl(@PathVariable Double id,
			@RequestBody ItemExecucao itemExecucao) {
		ItemExecucao alteraItemExecucao = itemExecucaoService.changeItemExecucao(id, itemExecucao);

		if (alteraItemExecucao != null) {
			return ResponseEntity.ok(itemExecucao);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteItemExecucaoControl(@PathVariable Double id) {
		boolean delete = itemExecucaoService.deleteItemExecucao(id);
		if (delete) {
			return ResponseEntity.ok().body("O produto foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}