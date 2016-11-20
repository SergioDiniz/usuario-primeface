package br.com.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.component.calendar.Calendar;

@Entity
public class Topico {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	@Enumerated
	private EstadoTopico estadoTopico;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataUltimaPostagem;
	
	@ManyToMany
	private Usuario usuario;
	
	@OneToMany(mappedBy="topico")
	private List<Comentario> comentarios;
	
	public Topico() {
		// TODO Auto-generated constructor stub
	}
	
}
