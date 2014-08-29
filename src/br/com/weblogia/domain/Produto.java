package br.com.weblogia.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="produtos")
public class Produto {
	
	private Long id;
	private String descricao;
	private boolean foraDeLinha;
	private Boolean emPromocao;
	private int euSouInt;
	private Integer euSouInteger;
	private Date euSouDate;
	private Double euSouDouble;
	private double euSoudoublePrimitivo;
	private Long  euSouLong;
	private long  euSouLongPrimitivo;
	@ManyToOne
	private Cliente cliente;
	
	@Column(name="usuario_maroto")
	private String usuarioMaroto;
	
	private Endereco endereco;
	
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
	public boolean isForaDeLinha() {
		return foraDeLinha;
	}
	public void setForaDeLinha(boolean foraDeLinha) {
		this.foraDeLinha = foraDeLinha;
	}
	public Boolean getEmPromocao() {
		return emPromocao;
	}
	public void setEmPromocao(Boolean emPromocao) {
		this.emPromocao = emPromocao;
	}
	public int getEuSouInt() {
		return euSouInt;
	}
	public void setEuSouInt(int euSouInt) {
		this.euSouInt = euSouInt;
	}
	public Integer getEuSouInteger() {
		return euSouInteger;
	}
	public void setEuSouInteger(Integer euSouInteger) {
		this.euSouInteger = euSouInteger;
	}
	public Date getEuSouDate() {
		return euSouDate;
	}
	public void setEuSouDate(Date euSouDate) {
		this.euSouDate = euSouDate;
	}
	public Double getEuSouDouble() {
		return euSouDouble;
	}
	public void setEuSouDouble(Double euSouDouble) {
		this.euSouDouble = euSouDouble;
	}
	public double getEuSoudoublePrimitivo() {
		return euSoudoublePrimitivo;
	}
	public void setEuSoudoublePrimitivo(double euSoudoublePrimitivo) {
		this.euSoudoublePrimitivo = euSoudoublePrimitivo;
	}
	public Long getEuSouLong() {
		return euSouLong;
	}
	public void setEuSouLong(Long euSouLong) {
		this.euSouLong = euSouLong;
	}
	public long getEuSouLongPrimitivo() {
		return euSouLongPrimitivo;
	}
	public void setEuSouLongPrimitivo(long euSouLongPrimitivo) {
		this.euSouLongPrimitivo = euSouLongPrimitivo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	

}
