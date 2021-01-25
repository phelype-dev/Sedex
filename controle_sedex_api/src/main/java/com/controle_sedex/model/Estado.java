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
@Table(name = "cad_estado")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "est_codigo")
	private long est_codigo;
	
	@Column(name = "estado", nullable = false, length = 200)
	private String estado;
	
	@Column(name = "sigla_estado", nullable = false, length = 2)
	private String sigla_estado;

	public long getEst_codigo() {
		return est_codigo;
	}

	public void setEst_codigo(long est_codigo) {
		this.est_codigo = est_codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSigla_estado() {
		return sigla_estado;
	}

	public void setSigla_estado(String sigla_estado) {
		this.sigla_estado = sigla_estado;
	}
}
