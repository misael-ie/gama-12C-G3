package br.com.CProjFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.CProjFinal.beans.AgenteFinanceiro;
import br.com.CProjFinal.dao.AgenteFinanceiroDAO;


@RestController
@CrossOrigin("*")
public class AgenteFinanceiroController {
	
	@Autowired
	private AgenteFinanceiroDAO dao;
	
	@GetMapping("/ag_financeiros")
	public ResponseEntity<List<AgenteFinanceiro>> getAll() {
		List<AgenteFinanceiro> lista = (List<AgenteFinanceiro>) dao.findAll();
		if (lista.size() == 0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("/ag_financeiro/{cod}")
	public ResponseEntity<AgenteFinanceiro> getArtista(@PathVariable int cod) {
		AgenteFinanceiro objeto = dao.findById(cod).orElse(null);
		if (objeto == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(objeto);
	}
	
	// FIX: Retornar somente os campos nome_agente, volume_transacional
	@GetMapping("/top_ag_financeiros")
	public ResponseEntity<List<SimpleAgent>> getTop10(){ 
		List<SimpleAgent> lista = (List<SimpleAgent>) dao.findByTop();
		return ResponseEntity.ok(lista);
	}
	
	
	
}
