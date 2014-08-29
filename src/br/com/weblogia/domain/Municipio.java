package br.com.weblogia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="municipios")
public class Municipio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	@Column(name="codigo_cgm")
	private String codigoCgm;
	
	@Column(name="codigo_ibge")
	private String codigoIbge;
	
	@ManyToOne
	@JoinColumn(name="estado_id")
	private Estado estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getCodigoCgm() {
		return codigoCgm;
	}
	public void setCodigoCgm(String codigoCgm) {
		this.codigoCgm = codigoCgm;
	}
	public String getCodigoIbge() {
		return codigoIbge;
	}
	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}
	
	public String getSiglaDoEstado(){
		estadoNaoPodeSerNulo();
		return estado.getSigla();
	}
	
	private void estadoNaoPodeSerNulo() {
		if(estado==null)
			throw new RuntimeException("Estado nao pode ser nulo");
	}
	
	
	

}
