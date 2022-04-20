package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	
	@PersistenceContext
	private EntityManager em;
	
	@GetMapping("/home")
	public String home(Model model) {
		
		 Query query = (Query) em.createQuery("select p from Pedido p", Pedido.class);
		 List<Pedido> pedidos = query.getResultList();
		
		model.addAttribute("pedidos", pedidos);
		
		return "home"; 
	}
}
