package br.com.weblogia.modelos;

public class Produto {
	
	private Long id;
	private String descricao;
	private boolean foraDeLinha;
	private Boolean emPromocao;
	private int euSouInt;
	private Integer euSouInteger;
	
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

}
