package br.com.uoldiveo.sitefmanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uoldiveo.sitefmanager.dao.JdbcUsuarioDao;
import br.com.uoldiveo.sitefmanager.modelo.Usuarios;

@Controller
public class LoginController {

	private final JdbcUsuarioDao dao;
	
	@Autowired
	public LoginController (JdbcUsuarioDao dao){
		this.dao = dao;
	}
	
	@RequestMapping("/login")
	public String loginForm(){
		return "login";
	}
	
	@RequestMapping("/menu")
	public String efetuaLogin (Usuarios  usuario, HttpSession session){
		if(dao.existeUsuario(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
			return "redirect:login";
	}
}
