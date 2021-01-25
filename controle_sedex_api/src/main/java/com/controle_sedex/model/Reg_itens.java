package com.controle_sedex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cad_reg_itens")
public class Reg_itens {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ips_codigo")
	private long ips_codigo;
	
	@ManyToOne
	@JoinColumn(name = "sed_codigo", referencedColumnName = "sed_codigo")
	private Reg_Sedex sed_codigo;
	
	@OneToOne
	@JoinColumn(name = "tit_codigo", referencedColumnName = "tit_codigo")
	private Tipo_Item tit_codigo;
	
	@Column(name = "ips_descricao", nullable = true, length = 255)
	private String ips_descricao;
	
	@OneToOne
	@JoinColumn(name = "equ_codigo", referencedColumnName = "equ_codigo")
	private Tipo_Equipamento equ_codigo;
	
	@Column(name = "ips_codigo_equip", nullable = true)
	private int ips_codigo_equip;
	
	@Column(name = "ips_cod_ra", nullable = true)
	private int ips_cod_ra;

	public long getIps_codigo() {
		return ips_codigo;
	}

	public void setIps_codigo(long ips_codigo) {
		this.ips_codigo = ips_codigo;
	}

	public Reg_Sedex getSed_codigo() {
		return sed_codigo;
	}

	public void setSed_codigo(Reg_Sedex sed_codigo) {
		this.sed_codigo = sed_codigo;
	}

	public Tipo_Item getTit_codigo() {
		return tit_codigo;
	}

	public void setTit_codigo(Tipo_Item tit_codigo) {
		this.tit_codigo = tit_codigo;
	}

	public String getIps_descricao() {
		return ips_descricao;
	}

	public void setIps_descricao(String ips_descricao) {
		this.ips_descricao = ips_descricao;
	}

	public Tipo_Equipamento getEqu_codigo() {
		return equ_codigo;
	}

	public void setEqu_codigo(Tipo_Equipamento equ_codigo) {
		this.equ_codigo = equ_codigo;
	}

	public int getIps_codigo_equip() {
		return ips_codigo_equip;
	}

	public void setIps_codigo_equip(int ips_codigo_equip) {
		this.ips_codigo_equip = ips_codigo_equip;
	}

	public int getIps_cod() {
		return ips_cod_ra;
	}

	public int getIps_cod_ra() {
		return ips_cod_ra;
	}

	public void setIps_cod_ra(int ips_cod_ra) {
		this.ips_cod_ra = ips_cod_ra;
	}

	public void setIps_cod(int ips_cod) {
		this.ips_cod_ra = ips_cod;
	}
	
}
