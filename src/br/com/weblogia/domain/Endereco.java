package br.com.weblogia.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Endereco implements Serializable {
	
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String complemento;
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private Municipio municipio;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getSiglaDoEstado() {
		municipioNaoPodeSerNulo();
		return municipio.getSiglaDoEstado();
	}
	
	public Estado getEstado() {
		municipioNaoPodeSerNulo();
		return municipio.getEstado();
	}
	
	private void municipioNaoPodeSerNulo() {
		if(municipio==null)
			throw new RuntimeException("Municipio nao pode ser nulo");
	}
	
	
	
	
	

}
