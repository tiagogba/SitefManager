package br.com.uoldiveo.sitefmanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uoldiveo.sitefmanager.dao.JdbcSitefDao;
import br.com.uoldiveo.sitefmanager.modelo.Lojas;


@Controller
public class SitefController {
	private final JdbcSitefDao dao;

	@Autowired
	public SitefController (JdbcSitefDao dao){
		this.dao = dao;
	}
	
	@RequestMapping ("cadastramento")
	public String form(){
		return "cadastro";
	}
	
	@RequestMapping
	public String adiciona(@Valid Lojas lojas, BindingResult result){
		if(result.hasFieldErrors("descricao")){
			return "cadastro";	
		}
		dao.adiciona(lojas);
		return  "adicionado";
	}
}
