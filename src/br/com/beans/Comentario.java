package br.com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.component.calendar.Calendar;

@Entity
public class Comentario {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(length=2000)
	private String conteudo;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Topico topico;
	
	public Comentario() {
		// TODO Auto-generated constructor stub
	}
	
	
}
