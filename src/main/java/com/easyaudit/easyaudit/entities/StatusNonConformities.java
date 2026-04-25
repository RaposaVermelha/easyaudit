package com.easyaudit.easyaudit.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_status_non_conformities")
public class StatusNonConformities implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Instant dt_created;
	private Instant dt_update;
	
	//associação com a classe Ticket
	//um status pode ser vinculados a vários tickets, mas, um ticket terá somente um status
	@JsonIgnore
	@OneToMany(mappedBy = "status")
	private List <Ticket> tickets = new ArrayList<>(); 
	
	public StatusNonConformities ( ) {
		
	}

	public StatusNonConformities(Long id, String description, Instant dt_created, Instant dt_update,
			List<Ticket> tickets) {
		super();
		this.id = id;
		this.description = description;
		this.dt_created = dt_created;
		this.dt_update = dt_update;
		this.tickets = tickets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getDt_created() {
		return dt_created;
	}

	public void setDt_created(Instant dt_created) {
		this.dt_created = dt_created;
	}

	public Instant getDt_update() {
		return dt_update;
	}

	public void setDt_update(Instant dt_update) {
		this.dt_update = dt_update;
	}

	public List <Ticket> getTickets() {
		return tickets;
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
		StatusNonConformities other = (StatusNonConformities) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
