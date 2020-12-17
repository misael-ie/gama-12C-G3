package br.com.CProjFinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.CProjFinal.beans.AgenteFinanceiro;
import br.com.CProjFinal.controller.SimpleAgent;


public interface AgenteFinanceiroDAO extends CrudRepository<AgenteFinanceiro, Integer>{
	
	public static String query_trans_vol = "select volume_transacional from mtb310_ag_financeiro where id_agente = :id";	
		
	@Query(value="select id_agente, nome_agente, volume_transacional from mtb310_ag_financeiro order by volume_transacional desc limit 10", nativeQuery = true)
	public List<SimpleAgent> findByTop();
	
	@Query(value = query_trans_vol, nativeQuery = true)
	public int findByIdMe(@Param("id") int id);
	
	
}