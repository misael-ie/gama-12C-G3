package br.com.CProjFinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.CProjFinal.beans.AgenteFinanceiro;
import br.com.CProjFinal.controller.SimpleAgent;


public interface AgenteFinanceiroDAO extends CrudRepository<AgenteFinanceiro, Integer>{
	
	@Query(value="select id_agente, nome_agente, volume_transacional from mtb310_ag_financeiro order by volume_transacional desc", nativeQuery = true)
	public List<SimpleAgent> findByTop();
	
}