package com.epcafes.dto.response;

import com.epcafes.entity.CapitalFixo;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class CapitalFixoResponseDTO {
	
	private long id;
	
	private double valorBemNovo;
	
	private double taxaDePoupanca;
	
	private int vidaHoras;
	
	private int vidaAnos;

	private int horasTrabalhadas;
	
	public CapitalFixoResponseDTO(CapitalFixo capital) {
		this.id = capital.getId();
		this.valorBemNovo = capital.getValorBemNovo();
		this.taxaDePoupanca = capital.getTaxaDePoupanca();
		this.vidaHoras = capital.getVidaHoras();
		this.vidaAnos = capital.getVidaAnos();
		this.horasTrabalhadas = capital.getHorasTrabalhadas();
	}
}
