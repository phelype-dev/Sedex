package com.controle_sedex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cad_mes")
public class Mes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mes_codigo")
	private long mes_codigo;
	
	@Column(name = "mes_sistema", nullable = true, length = 20 )
	private String mes_sistema;
	
	@Column(name = "mes_text", nullable = true, length = 20 )
	private String mes_texto;

	public long getMes_codigo() {
		return mes_codigo;
	}

	public void setMes_codigo(long mes_codigo) {
		this.mes_codigo = mes_codigo;
	}

	public String getMes_sistema() {
		return mes_sistema;
	}

	public void setMes_sistema(String mes_sistema) {
		this.mes_sistema = mes_sistema;
	}

	public String getMes_texto() {
		return mes_texto;
	}

	public void setMes_texto(String mes_texto) {
		this.mes_texto = mes_texto;
	}

}
