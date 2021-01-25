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
@Table(name = "cad_tipo_equipamento")
public class Tipo_Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equ_codigo")
	private long equ_codigo;
	
	@Column(name = "equ_tipo", nullable = false, length = 150)
	private String equ_tipo;

	public long getEqu_codigo() {
		return equ_codigo;
	}

	public void setEqu_codigo(long equ_codigo) {
		this.equ_codigo = equ_codigo;
	}

	public String getEqu_tipo() {
		return equ_tipo;
	}

	public void setEqu_tipo(String equ_tipo) {
		this.equ_tipo = equ_tipo;
	}
	
}
