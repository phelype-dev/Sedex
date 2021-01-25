package com.controle_sedex.model;

import java.sql.Date;

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
@Table(name = "cad_reg_sedex")
public class Reg_Sedex {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sed_codigo")
	private long sed_codigo;
	
	@Column(name = "sed_data_postagem", nullable = false)
	private Date sed_data_postagem;
	
	@OneToOne
	@JoinColumn(name = "emp_codigo", referencedColumnName = "emp_codigo")
	private Empresa emp_codigo;
	
	@OneToOne
	@JoinColumn(name = "rem_codigo", referencedColumnName = "rem_codigo")
	private Remetente rem_codigo;
	
	@OneToOne
	@JoinColumn(name = "cid_codigo", referencedColumnName = "cid_codigo")
	private Cidade cid_codigo;
	
	@OneToOne
	@JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
	private Estado est_codigo;
	
	@OneToOne
	@JoinColumn(name = "des_codigo", referencedColumnName = "des_codigo")
	private Destinatarios des_codigo;
	
	@Column(name = "sed_codigo_rastreio", nullable = true, length = 20)
	private String sed_codigo_rastreio;
	
	@Column(name = "sed_valor", nullable = true)
	private float sed_valor;
	
	@Column(name = "sed_pago", nullable = true)
	private boolean sed_pago;
	
	@Column(name = "set_extraviou", nullable = true)
	private boolean sed_extraviou;
	
	@Column(name = "sed_operador", nullable = true)
	private String sed_operador;
	
	@Column(name = "sed_data_modificacao", nullable = true)
	private Date sed_data_modificacao;

	public long getSed_codigo() {
		return sed_codigo;
	}

	public void setSed_codigo(long sed_codigo) {
		this.sed_codigo = sed_codigo;
	}

	public Date getSed_data_postagem() {
		return sed_data_postagem;
	}

	public void setSed_data_postagem(Date sed_data_postagem) {
		this.sed_data_postagem = sed_data_postagem;
	}

	public Empresa getEmp_codigo() {
		return emp_codigo;
	}

	public void setEmp_codigo(Empresa emp_codigo) {
		this.emp_codigo = emp_codigo;
	}

	public Remetente getRem_codigo() {
		return rem_codigo;
	}

	public void setRem_codigo(Remetente rem_codigo) {
		this.rem_codigo = rem_codigo;
	}

	public Cidade getCid_codigo() {
		return cid_codigo;
	}

	public void setCid_codigo(Cidade cid_codigo) {
		this.cid_codigo = cid_codigo;
	}

	public Estado getEst_codigo() {
		return est_codigo;
	}

	public void setEst_codigo(Estado est_codigo) {
		this.est_codigo = est_codigo;
	}

	public Destinatarios getDes_codigo() {
		return des_codigo;
	}

	public void setDes_codigo(Destinatarios des_codigo) {
		this.des_codigo = des_codigo;
	}

	public String getSed_codigo_rastreio() {
		return sed_codigo_rastreio;
	}

	public void setSed_codigo_rastreio(String sed_codigo_rastreio) {
		this.sed_codigo_rastreio = sed_codigo_rastreio;
	}

	public float getSed_valor() {
		return sed_valor;
	}

	public void setSed_valor(float sed_valor) {
		this.sed_valor = sed_valor;
	}

	public boolean isSed_pago() {
		return sed_pago;
	}

	public void setSed_pago(boolean sed_pago) {
		this.sed_pago = sed_pago;
	}

	public boolean isSed_extraviou() {
		return sed_extraviou;
	}

	public void setSed_extraviou(boolean sed_extraviou) {
		this.sed_extraviou = sed_extraviou;
	}

	public String getSed_operador() {
		return sed_operador;
	}

	public void setSed_operador(String sed_operador) {
		this.sed_operador = sed_operador;
	}

	public Date getSed_data_modificacao() {
		return sed_data_modificacao;
	}

	public void setSed_data_modificacao(Date sed_data_modificacao) {
		this.sed_data_modificacao = sed_data_modificacao;
	}
	
}
