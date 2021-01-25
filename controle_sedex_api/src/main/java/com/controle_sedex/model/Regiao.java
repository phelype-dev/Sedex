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
@Table(name = "cad_regiao")
public class Regiao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reo_codigo")
	private long reo_codigo;
	
	@Column(name = "reo_regiao")
	private String reo_regiao;

	public long getReo_codigo() {
		return reo_codigo;
	}

	public void setReo_codigo(long reo_codigo) {
		this.reo_codigo = reo_codigo;
	}

	public String getReo_regiao() {
		return reo_regiao;
	}

	public void setReo_regiao(String reo_regiao) {
		this.reo_regiao = reo_regiao;
	}
	
}
