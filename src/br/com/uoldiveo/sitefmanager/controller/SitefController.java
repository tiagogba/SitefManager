package br.com.uoldiveo.sitefmanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
//	
//	@RequestMapping ("menu")
//	public String form(){
//		return "menu";
//	}
	
	
	@RequestMapping ("adiciona")
	public String form(){
		return "cadastro";
	}
	
	@RequestMapping ("adicionaloja")
	public String adiciona(@Valid Lojas lojas, BindingResult result){
		if(result.hasFieldErrors("descricao")){
			return "cadastro";
		}
		dao.adiciona(lojas);
		return  "cadastro";
	}
	
	@RequestMapping("remove")
	public String remove(Lojas lojas){
		dao.remove(lojas);
		return "redirect:lista";
	}
	
	@RequestMapping("lista")
	public String lista(Model model){
		model.addAttribute("lojas", dao.lista());
		return "listaloja";
	}
	
	@RequestMapping("mostralojas")
	public String mostra(Long id, Model model){
		model.addAttribute("lojas", dao.buscaPorId(id));
		return "mostra";
	}
	@RequestMapping("alteralojas")
	public String altera (Lojas lojas){
		dao.altera(lojas);
		return "redirect:lista";
	}
}
