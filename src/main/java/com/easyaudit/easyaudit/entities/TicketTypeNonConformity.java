package com.easyaudit.easyaudit.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/* entidade para registrar os ids dos tickets vinculados aos tipos de não conformidade */
@Entity
@Table(name = "tb_ticket_type_non_conformity")
public class TicketTypeNonConformity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant dt_created;
	private Instant dt_updated;
	
	//associações
	//usuario que vinculou um tipo ao ticket
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User auditor;
	
	//id do ticket
	@ManyToOne
	@JoinColumn(name = "ticket_id")
	private Ticket ticket;
	
	//id do tipo de não conformidade
	@ManyToOne
	@JoinColumn(name = "type_non_conformity_id")
	private TypeNonConformities type;
	
	public TicketTypeNonConformity () {
		
	}

	public TicketTypeNonConformity(Long id, Instant dt_created, Instant dt_updated, User auditor, Ticket ticket,
			TypeNonConformities type) {
		super();
		this.id = id;
		this.dt_created = dt_created;
		this.dt_updated = dt_updated;
		this.auditor = auditor;
		this.ticket = ticket;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDt_created() {
		return dt_created;
	}

	public void setDt_created(Instant dt_created) {
		this.dt_created = dt_created;
	}

	public Instant getDt_updated() {
		return dt_updated;
	}

	public void setDt_updated(Instant dt_updated) {
		this.dt_updated = dt_updated;
	}

	public User getAuditor() {
		return auditor;
	}

	public void setAuditor(User auditor) {
		this.auditor = auditor;
	}

	public Ticket getTickets() {
		return ticket;
	}

	public void setTickets(Ticket tickets) {
		this.ticket = tickets;
	}

	public TypeNonConformities getType() {
		return type;
	}

	public void setType(TypeNonConformities type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketTypeNonConformity other = (TicketTypeNonConformity) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
