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
@Table(name = "cad_remetente")
public class Remetente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rem_codigo")
	private long rem_codigo;
	
	@Column(name = "rem_remetente", nullable = false, length = 150)
	private String rem_remetente;
	
	@Column(name = "rem_abreviado", nullable = false, length = 150)
	private String rem_abreviado;
	
	@Column(name = "rem_fixo", nullable = true, length = 15)
	private String rem_fixo;
	
	@Column(name = "rem_movel", nullable = true, length = 15)
	private String rem_movel;
	
	@OneToOne
	@JoinColumn(name = "emp_codigo", referencedColumnName = "emp_codigo")
	private Empresa emp_codigo;
	
	@Column(name = "rem_ativo", nullable = false)
	private boolean rem_ativo;

	public long getRem_codigo() {
		return rem_codigo;
	}

	public void setRem_codigo(long rem_codigo) {
		this.rem_codigo = rem_codigo;
	}

	public String getRem_remetente() {
		return rem_remetente;
	}

	public void setRem_remetente(String rem_remetente) {
		this.rem_remetente = rem_remetente;
	}

	public String getRem_abreviado() {
		return rem_abreviado;
	}

	public void setRem_abreviado(String rem_abreviado) {
		this.rem_abreviado = rem_abreviado;
	}

	public String getRem_fixo() {
		return rem_fixo;
	}

	public void setRem_fixo(String rem_fixo) {
		this.rem_fixo = rem_fixo;
	}

	public String getRem_movel() {
		return rem_movel;
	}

	public void setRem_movel(String rem_movel) {
		this.rem_movel = rem_movel;
	}

	public Empresa getEmp_codigo() {
		return emp_codigo;
	}

	public void setEmp_codigo(Empresa emp_codigo) {
		this.emp_codigo = emp_codigo;
	}

	public boolean isRem_ativo() {
		return rem_ativo;
	}

	public void setRem_ativo(boolean rem_ativo) {
		this.rem_ativo = rem_ativo;
	}
	
}
