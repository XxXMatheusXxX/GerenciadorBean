package com.gerenciador.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tarefa")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	@NotNull (message = "Não pode campo vazio")
	@Column(name = "nome")
	private String nome;
	
	@NotBlank(message = "dataLimiteExecucao é obrigatório")
	@NotNull (message = "Não pode campo vazio")
	@Column(name = "dataLimiteExecucao")
	private String dataLimiteExecucao;
	
	@NotBlank(message = "detalhesTarefa é obrigatório")
	@NotNull (message = "Não pode campo vazio")
	@Column(name = "detalhesTarefa")
	private String detalhesTarefa;
	
	
	@NotBlank(message = "statusTarefa é obrigatório")
	@NotNull (message = "Não pode campo vazio")
	@Column(name = "statusTarefa")
	private String statusTarefa;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataLimiteExecucao() {
		return dataLimiteExecucao;
	}

	public void setDataLimiteExecucao(String dataLimiteExecucao) {
		this.dataLimiteExecucao = dataLimiteExecucao;
	}
	

	public String getDetalhesTarefa() {
		return nome;
	}

	public void setDetalhesTarefa(String detalhesTarefa) {
		this.detalhesTarefa = detalhesTarefa;
	}
	
	
	
	public String getStatusTarefa() {
		return dataLimiteExecucao;
	}

	public void setStatusTarefa( String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}
}