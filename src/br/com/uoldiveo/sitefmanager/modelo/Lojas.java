package br.com.uoldiveo.sitefmanager.modelo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Lojas {
	
	@NotNull @Size(min=5, max=255)
	private String empresa;
	private String loja;
	private String razaoSocial;
	private String cnpj;
	
	//Getters and Setters
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getLoja() {
		return loja;
	}
	public void setLoja(String loja) {
		this.loja = loja;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	

}
