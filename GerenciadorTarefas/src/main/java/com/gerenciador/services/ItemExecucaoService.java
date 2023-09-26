package com.gerenciador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.entities.ItemExecucao;
import com.gerenciador.repository.ItemExecucaoRepository;

@Service
public class ItemExecucaoService {
	private final ItemExecucaoRepository ItemExecucaoRepository;


	@Autowired
	public ItemExecucaoService(ItemExecucaoRepository ItemExecucaoRepository) {
		this.ItemExecucaoRepository = ItemExecucaoRepository;
	}

	public List<ItemExecucao> getAllItemExecucaos() {
		return ItemExecucaoRepository.findAll();
	}

	public ItemExecucao getItemExecucaoByPercentual(Double percentual) {
		Optional<ItemExecucao> ItemExecucao = ItemExecucaoRepository.findById(percentual);
		return ItemExecucao.orElse(null);
	}

	public ItemExecucao saveItemExecucao(ItemExecucao ItemExecucao) {
		return ItemExecucaoRepository.save(ItemExecucao);
	}

	public ItemExecucao changeItemExecucao(Double percentual, ItemExecucao changeTaref) {
		Optional<ItemExecucao> existeItemExecucao = ItemExecucaoRepository.findById(percentual);
		if (existeItemExecucao.isPresent()) {
			changeTaref.setPercentual(percentual);
			return ItemExecucaoRepository.save(changeTaref);
		}
		return null;
	}

	public boolean deleteItemExecucao(Double percentual) {
		Optional<ItemExecucao> existeItemExecucao= ItemExecucaoRepository.findById(percentual);
		if (existeItemExecucao.isPresent()) {
			ItemExecucaoRepository.deleteById(percentual);
			return true;
		}
		return false;
	}

}