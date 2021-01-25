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
@Table(name = "cad_tipo_empresa")
public class Tipo_Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tem_codigo")
	private long tem_codigo;
	
	@Column(name = "tem_tipo_empresa")
	private String tem_tipo_empresa;

	public long getTem_codigo() {
		return tem_codigo;
	}

	public void setTem_codigo(long tem_codigo) {
		this.tem_codigo = tem_codigo;
	}

	public String getTem_tipo_empresa() {
		return tem_tipo_empresa;
	}

	public void setTem_tipo_empresa(String tem_tipo_empresa) {
		this.tem_tipo_empresa = tem_tipo_empresa;
	}
	
	

}
