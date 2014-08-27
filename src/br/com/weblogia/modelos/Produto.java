package br.com.weblogia.modelos;

public class Produto {
	
	private Long id;
	private String descricao;
	private boolean foraDeLinha;
	
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

}
