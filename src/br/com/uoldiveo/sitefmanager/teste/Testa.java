package br.com.uoldiveo.sitefmanager.teste;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Testa {

	@RequestMapping("/hello")
	public String execute(){
		return "ok";
	}
}
