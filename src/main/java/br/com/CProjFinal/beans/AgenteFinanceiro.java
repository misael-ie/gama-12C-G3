package br.com.CProjFinal.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mtb310_ag_financeiro")
public class AgenteFinanceiro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agente")
	private int id_agente;
	
	@Column(name = "nome_agente", length = 100)
	private String nome_agente;
	
	@Column(name = "volume_transacional")
	private float volume_transacional;
	
	@OneToMany(mappedBy = "ag_financeiro", cascade = CascadeType.ALL) // A Classe Artista estão do lado "1" no SGBD relacional
	@JsonIgnoreProperties("ag_financeiro")
	private List<Transacao> transacoes;

	public int getId_agente() {
		return id_agente;
	}
	
	public void setId_agente(int id_agente) {
		this.id_agente = id_agente;
	}

	public String getNome_agente() {
		return nome_agente;
	}

	public void setNome_agente(String nome_agente) {
		this.nome_agente = nome_agente;
	}

	public float getVolume_transacional() {
		return volume_transacional;
	}

	public void setVolume_transacional(float volume_transacional) {
		this.volume_transacional = volume_transacional;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public AgenteFinanceiro(int id_agente, String nome_agente, float volume_transacional, List<Transacao> transacoes) {
		super();
		this.id_agente = id_agente;
		this.nome_agente = nome_agente;
		this.volume_transacional = volume_transacional;
		this.transacoes = transacoes;
	}

	public AgenteFinanceiro() {
		super();
	}

	
	
	
}
