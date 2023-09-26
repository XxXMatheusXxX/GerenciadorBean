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
@Table(name = "itemexecucao")
public class ItemExecucao {



	@NotBlank(message = "percentual é obrigatório")
	@NotNull(message = "Não pode campo vazio")
	@Column(name = "percentual")
	private Double percentual;

	@NotBlank(message = "descricao é obrigatório")
	@NotNull(message = "Não pode campo vazio")
	@Column(name = "descricao")
	private String descricao;

	@NotBlank(message = "dataExecucao é obrigatório")
	@NotNull(message = "Não pode campo vazio")
	@Column(name = "dataExecucao")
	private String dataExecucao;



	public String getDataExecucao() {
		return dataExecucao;
	}

	public void setDataExecucao(String dataExecucao) {
		this.dataExecucao = dataExecucao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPercentual() {
		return percentual;
	}

	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}

}