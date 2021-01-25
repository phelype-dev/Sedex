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
@Table(name = "cad_tipo_item")
public class Tipo_Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tit_codigo")
	private long tit_codigo;
	
	@Column(name = "tit_tipo_item", nullable = false, length = 15)
	private String tit_tipo_item;

	public long getTit_codigo() {
		return tit_codigo;
	}

	public void setTit_codigo(long tit_codigo) {
		this.tit_codigo = tit_codigo;
	}

	public String getTit_tipo_item() {
		return tit_tipo_item;
	}

	public void setTit_tipo_item(String tit_tipo_item) {
		this.tit_tipo_item = tit_tipo_item;
	}
	
}
