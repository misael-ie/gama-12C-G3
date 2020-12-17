package br.com.CProjFinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.CProjFinal.beans.Transacao;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer>{
	public static String query_daily_transactions = "select status, data_hora, count(status) as total_transacoes from mtb310_transaction group by status";
	
	public static String query_total_trans_by_agents = "select f.nome_agente, t.status, count(t.status) as total_transactions from mtb310_transaction t inner join mtb310_ag_financeiro f on t.ag_financeiro_id_agente = f.id_agente group by t.status, f.nome_agente";
	
	public static String query_total_trans_by_agent = "select f.nome_agente, t.status, count(t.status) as total_transactions from mtb310_transaction t inner join mtb310_ag_financeiro f on t.ag_financeiro_id_agente = f.id_agente where f.id_agente = :id group by t.status, f.nome_agente";	
	
	public static String query_top_10_ag_fin = "select nome_agente, volume_transacional from mtb310_ag_financeiro order by volume_transacional desc";
	

	@Query(value = query_daily_transactions, nativeQuery = true)
	public List<String> findByDailyTransactions();
	
	@Query(value = query_total_trans_by_agents, nativeQuery = true)
	public List<String> TotalTransByAgents();	

	@Query(value = query_total_trans_by_agent, nativeQuery = true)
	public List<String> TotalTransByAgent(@Param("id") int id);
	
	@Query(value = query_top_10_ag_fin, nativeQuery = true)
	public List<String> TopAgFin();
	
	// Pós feedback
	
	public static String success_ag = "select count(t.status) from mtb310_transaction t inner join mtb310_ag_financeiro f on t.ag_financeiro_id_agente = f.id_agente where t.status = 0 and f.id_agente= :id";	
	
	public static String fail_ag = "select count(t.status) from mtb310_transaction t inner join mtb310_ag_financeiro f on t.ag_financeiro_id_agente = f.id_agente where t.status = 1 and f.id_agente= :id";	
	
	public static String fraud_ag = "select count(t.status) from mtb310_transaction t inner join mtb310_ag_financeiro f on t.ag_financeiro_id_agente = f.id_agente where t.status = 2 and f.id_agente= :id";	
	
	public static String total_ag = "select count(t.status) from mtb310_transaction t inner join mtb310_ag_financeiro f on t.ag_financeiro_id_agente = f.id_agente where f.id_agente= :id";	
		
	@Query(value = success_ag, nativeQuery = true)
	public int findBySuccess(@Param("id") int id);
	
	@Query(value = fail_ag, nativeQuery = true)
	public int findByFail(@Param("id") int id);
	
	@Query(value = fraud_ag, nativeQuery = true)
	public int findByFraud(@Param("id") int id);
	
	@Query(value = total_ag, nativeQuery = true)
	public int findByTotal(@Param("id") int id);	
	
}
