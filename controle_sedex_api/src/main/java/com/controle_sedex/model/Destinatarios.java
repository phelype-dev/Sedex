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
@Table(name = "cad_destinatarios")
public class Destinatarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "des_codigo")
	private Long des_codigo;
	
	@Column(name = "des_destinatario", nullable = false, length = 150)
	private String des_destinatario;
	
	@Column(name = "des_aos_cuidados", nullable = false, length = 150)
	private String des_aos_cuidados;
	
	@Column(name = "des_aos_cuidados_abrev", nullable = false, length = 100)
	private String des_aos_cuidados_abrev;
	
	@Column(name = "des_cpf", nullable = true, length = 11)
	private String des_cpf;
	
	@Column(name = "des_logradouro", nullable = false, length = 200)
	private String des_logradouro;
	
	@Column(name = "des_numero", nullable = true, length = 4)
	private int des_numero;
	
	@Column(name = "des_complemento", nullable = true, length = 200)
	private String des_complemento;
	
	@Column(name = "des_bairro", nullable = false, length = 200)
	private String des_bairro;
	
	@OneToOne
	@JoinColumn(name = "cid_cidade", referencedColumnName = "cid_codigo")
	private Cidade cid_cidade;
	
	@OneToOne
	@JoinColumn(name = "est_estado", referencedColumnName = "est_codigo")
	private Estado est_estado;
	
	@Column(name = "des_cep", nullable = false, length = 8)
	private String des_cep;
	
	@Column(name = "des_fixo", nullable = true, length = 15)
	private String des_fixo;
	
	@Column(name = "des_movel", nullable = true, length = 15)
	private String des_movel;
	
	@OneToOne
	@JoinColumn(name = "des_transportadora", referencedColumnName = "emp_codigo")
	private Empresa des_transpotadora;
	
	@Column(name = "des_ativo", nullable = false)
	private boolean des_ativo;
	
	@Column(name = "des_data_alteracao", nullable = true)
	private Date des_data_alteracao;
	
	@Column(name = "des_latitude", nullable = true, length = 20)
	private String des_latitude;
	
	@Column(name = "des_longitude", nullable = true, length = 20)
	private String des_longitude;

	public Long getDes_codigo() {
		return des_codigo;
	}

	public void setDes_codigo(Long des_codigo) {
		this.des_codigo = des_codigo;
	}

	public String getDes_destinatario() {
		return des_destinatario;
	}

	public void setDes_destinatario(String des_destinatario) {
		this.des_destinatario = des_destinatario;
	}

	public String getDes_aos_cuidados() {
		return des_aos_cuidados;
	}

	public void setDes_aos_cuidados(String des_aos_cuidados) {
		this.des_aos_cuidados = des_aos_cuidados;
	}

	public String getDes_aos_cuidados_abrev() {
		return des_aos_cuidados_abrev;
	}

	public void setDes_aos_cuidados_abrev(String des_aos_cuidados_abrev) {
		this.des_aos_cuidados_abrev = des_aos_cuidados_abrev;
	}

	public String getDes_cpf() {
		return des_cpf;
	}

	public void setDes_cpf(String des_cpf) {
		this.des_cpf = des_cpf;
	}

	public String getDes_logradouro() {
		return des_logradouro;
	}

	public void setDes_logradouro(String des_logradouro) {
		this.des_logradouro = des_logradouro;
	}

	public int getDes_numero() {
		return des_numero;
	}

	public void setDes_numero(int des_numero) {
		this.des_numero = des_numero;
	}

	public String getDes_complemento() {
		return des_complemento;
	}

	public void setDes_complemento(String des_complemento) {
		this.des_complemento = des_complemento;
	}

	public String getDes_bairro() {
		return des_bairro;
	}

	public void setDes_bairro(String des_bairro) {
		this.des_bairro = des_bairro;
	}

	public Cidade getCid_cidade() {
		return cid_cidade;
	}

	public void setCid_cidade(Cidade cid_cidade) {
		this.cid_cidade = cid_cidade;
	}

	public Estado getEst_estado() {
		return est_estado;
	}

	public void setEst_estado(Estado est_estado) {
		this.est_estado = est_estado;
	}

	public String getDes_cep() {
		return des_cep;
	}

	public void setDes_cep(String des_cep) {
		this.des_cep = des_cep;
	}

	public String getDes_fixo() {
		return des_fixo;
	}

	public void setDes_fixo(String des_fixo) {
		this.des_fixo = des_fixo;
	}

	public String getDes_movel() {
		return des_movel;
	}

	public void setDes_movel(String des_movel) {
		this.des_movel = des_movel;
	}

	public Empresa getDes_transpotadora() {
		return des_transpotadora;
	}

	public void setDes_transpotadora(Empresa des_transpotadora) {
		this.des_transpotadora = des_transpotadora;
	}

	public boolean isDes_ativo() {
		return des_ativo;
	}

	public void setDes_ativo(boolean des_ativo) {
		this.des_ativo = des_ativo;
	}

	public Date getDes_data_alteracao() {
		return des_data_alteracao;
	}

	public void setDes_data_alteracao(Date des_data_alteracao) {
		this.des_data_alteracao = des_data_alteracao;
	}

	public String getDes_latitude() {
		return des_latitude;
	}

	public void setDes_latitude(String des_latitude) {
		this.des_latitude = des_latitude;
	}

	public String getDes_longitude() {
		return des_longitude;
	}

	public void setDes_longitude(String des_longitude) {
		this.des_longitude = des_longitude;
	}
	
}
