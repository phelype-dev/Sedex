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
@Table(name = "cad_empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long emp_codigo;
	
	@Column(name = "emp_cnpj", nullable = false, length = 18)
	private String emp_cnpj;
	
	@Column(name = "emp_razao_social", nullable = true, length = 150)
	private String emp_razao_social;
	
	@Column(name = "emp_operacao", nullable = true, length = 150)
	private String emp_operacao;
	
	@Column(name = "emp_descricao", nullable = true, length = 150)
	private String emp_descricao;
	
	@Column(name = "emp_logradouro", nullable = true, length = 200)
	private String emp_logradouro;
	
	@Column(name = "emp_numero", nullable = true, length = 4)
	private int emp_numero;
	
	@Column(name = "emp_complemento", nullable = true, length = 150)
	private String emp_complemento;
	
	@Column(name = "emp_bairro", nullable = true, length = 150)
	private String emp_bairro;

	@OneToOne
	@JoinColumn(name = "emp_cidade", referencedColumnName = "cid_codigo")
	private Cidade emp_cidade;
	
	@OneToOne
	@JoinColumn(name = "emp_estado", referencedColumnName = "est_codigo")
	private Estado emp_estado;
	
	@Column(name = "emp_cep", nullable = true, length = 9)
	private String emp_cep;
	
	@Column(name = "emp_fixo", nullable = true, length = 14)
	private String emp_fixo;

	@OneToOne
	@JoinColumn(name = "tem_codigo", referencedColumnName = "tem_codigo")
	private Tipo_Empresa tem_codigo;

	public long getEmp_codigo() {
		return emp_codigo;
	}

	public void setEmp_codigo(long emp_codigo) {
		this.emp_codigo = emp_codigo;
	}

	public String getEmp_cnpj() {
		return emp_cnpj;
	}

	public void setEmp_cnpj(String emp_cnpj) {
		this.emp_cnpj = emp_cnpj;
	}

	public String getEmp_razao_social() {
		return emp_razao_social;
	}

	public void setEmp_razao_social(String emp_razao_social) {
		this.emp_razao_social = emp_razao_social;
	}

	public String getEmp_operacoa() {
		return emp_operacao;
	}

	public void setEmp_operacoa(String emp_operacoa) {
		this.emp_operacao = emp_operacoa;
	}

	public String getEmp_descricao() {
		return emp_descricao;
	}

	public void setEmp_descricao(String emp_descricao) {
		this.emp_descricao = emp_descricao;
	}

	public String getEmp_logradouro() {
		return emp_logradouro;
	}

	public void setEmp_logradouro(String emp_logradouro) {
		this.emp_logradouro = emp_logradouro;
	}

	public int getEmp_numero() {
		return emp_numero;
	}

	public void setEmp_numero(int emp_numero) {
		this.emp_numero = emp_numero;
	}

	public String getEmp_complemento() {
		return emp_complemento;
	}

	public void setEmp_complemento(String emp_complemento) {
		this.emp_complemento = emp_complemento;
	}

	public String getEmp_bairro() {
		return emp_bairro;
	}

	public void setEmp_bairro(String emp_bairro) {
		this.emp_bairro = emp_bairro;
	}

	public Cidade getEmp_cidade() {
		return emp_cidade;
	}

	public void setEmp_cidade(Cidade emp_cidade) {
		this.emp_cidade = emp_cidade;
	}

	public Estado getEmp_estado() {
		return emp_estado;
	}

	public void setEmp_estado(Estado emp_estado) {
		this.emp_estado = emp_estado;
	}

	public String getEmp_cep() {
		return emp_cep;
	}

	public void setEmp_cep(String emp_cep) {
		this.emp_cep = emp_cep;
	}

	public String getEmp_fixo() {
		return emp_fixo;
	}

	public void setEmp_fixo(String emp_fixo) {
		this.emp_fixo = emp_fixo;
	}

	public Tipo_Empresa getTem_codigo() {
		return tem_codigo;
	}

	public void setTem_codigo(Tipo_Empresa tem_codigo) {
		this.tem_codigo = tem_codigo;
	}
}
