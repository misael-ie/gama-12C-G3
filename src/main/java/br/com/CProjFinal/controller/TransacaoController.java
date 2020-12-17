package br.com.CProjFinal.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.CProjFinal.dao.TransacaoDAO;

@RestController
@CrossOrigin("*")
public class TransacaoController {
	
	@Autowired
	private TransacaoDAO dao;
	
	// TODO: Retornar um JSON melhor
	@GetMapping("/daily_transactions")
	public ResponseEntity<List<String>> getDailyTransactions(){
		List<String> lista = (List<String>) dao.findByDailyTransactions();
		return ResponseEntity.ok(lista);
	}
	
	// TODO: Retornar um JSON melhor
	@GetMapping("/total_transactions_by_agents")
	public ResponseEntity<List<String>> getTotalTransByAgents(){
		List<String> lista = (List<String>) dao.TotalTransByAgents();
		return ResponseEntity.ok(lista);
	}
	
	// TODO: Retornar um JSON melhor
	@GetMapping("/total_transactions_by_agent/{id}")
	public ResponseEntity<List<String>> getTotalTransByAgent(@PathVariable int id){
		List<String> lista = (List<String>) dao.TotalTransByAgent(id);
		if (lista.size() == 0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}	
	
	// TODO: Retornar um JSON melhor
	@GetMapping("/top_ag_fin")
	public ResponseEntity<List<String>> getTopAgFin(){
		List<String> lista = (List<String>) dao.TopAgFin();
		return ResponseEntity.ok(lista);
	}	
	
}
