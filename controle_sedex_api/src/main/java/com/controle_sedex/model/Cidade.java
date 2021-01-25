package com.controle_sedex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cad_cidade")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid_codigo")
	private long cid_codigo;
	
	@Column(name = "municipio", nullable = false, length = 200)
	private String municipio;
	
	@OneToOne
	@JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
	private Estado est_codigo;

	public long getCid_codigo() {
		return cid_codigo;
	}

	public void setCid_codigo(long cid_codigo) {
		this.cid_codigo = cid_codigo;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Estado getEst_codigo() {
		return est_codigo;
	}

	public void setEst_codigo(Estado est_codigo) {
		this.est_codigo = est_codigo;
	}
	
	
}
