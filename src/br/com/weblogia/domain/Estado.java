package br.com.weblogia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estados")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sigla;
	private String descricao;
	
	@Column(name="aliquota_origem")
	private double aliquotaDeOrigem;
	
	@Column(name="aliquota_destino")
	private double aliquotaDeDestino;
	
	@Column(name="aliquota_interna")
	private double aliquotaInterna;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getAliquotaDeOrigem() {
		return aliquotaDeOrigem;
	}

	public void setAliquotaDeOrigem(double aliquotaDeOrigem) {
		this.aliquotaDeOrigem = aliquotaDeOrigem;
	}

	public double getAliquotaDeDestino() {
		return aliquotaDeDestino;
	}

	public void setAliquotaDeDestino(double aliquotaDeDestino) {
		this.aliquotaDeDestino = aliquotaDeDestino;
	}

	public double getAliquotaInterna() {
		return aliquotaInterna;
	}

	public void setAliquotaInterna(double aliquotaInterna) {
		this.aliquotaInterna = aliquotaInterna;
	}
	
	@Override
	public String toString(){
		return this.sigla;
	}
	
	

}
