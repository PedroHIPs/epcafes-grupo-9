package com.epcafes.entity;

import java.io.Console;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;


@Log
@Entity
@Table(name = "capital_fixo")
@Getter
@Setter
public class CapitalFixo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private long id;
	
	@Column(name = "valor_bem_novo", nullable = false)
	private double valorBemNovo;
	
	@Column(name = "taxa_poupanca", nullable = false)
	private double taxaDePoupanca;
	
	@Column(name = "vida_horas", nullable = false)
	private int vidaHoras;
	
	@Column(name = "vida_anos", nullable = false)
	private int vidaAnos;

	@Column(name = "horas_trabalhadas", nullable = false)
	private int horasTrabalhadas;
	
	@Column(name = "remuneracao", nullable = true)
	private double remuneracao;
	
	private double calcularRemuneracao(double valorBemNovo, double taxaDePoupanca, int vidaHoras, int vidaAnos, int horasTrabalhadas) {
	    return (((valorBemNovo/2) * taxaDePoupanca)/(vidaHoras/vidaAnos))*horasTrabalhadas;
	}
	
	@Builder
	public CapitalFixo(double valorBemNovo, double taxaDePoupanca, int vidaHoras, int vidaAnos, int horasTrabalhadas) {
		this.valorBemNovo = valorBemNovo;
		this.taxaDePoupanca = taxaDePoupanca;
		this.vidaHoras = vidaHoras;
		this.vidaAnos = vidaAnos;
		this.horasTrabalhadas = horasTrabalhadas;
		this.remuneracao = calcularRemuneracao(valorBemNovo, taxaDePoupanca, vidaHoras, vidaAnos, horasTrabalhadas);
	}
	
    public CapitalFixo() {
    }
}
