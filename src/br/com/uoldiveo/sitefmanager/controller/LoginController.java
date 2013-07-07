package br.com.uoldiveo.sitefmanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uoldiveo.sitefmanager.dao.JdbcUsuarioDao;
import br.com.uoldiveo.sitefmanager.modelo.Usuarios;

@Controller
public class LoginController {

	
	@RequestMapping("/login")
	public String loginForm(){
		return "login";
	}
	
	@RequestMapping("/efetuaLogin")
	public String efetuaLogin (Usuarios  usuario, HttpSession session){
		if(new JdbcUsuarioDao().existeUsuario(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
			return "redirect:loginForm";
	}
}
