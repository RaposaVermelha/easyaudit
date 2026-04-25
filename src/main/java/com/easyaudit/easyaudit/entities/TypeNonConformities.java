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
@Table(name = "tb_type_non_conformities")
public class TypeNonConformities implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Instant dt_created;
	private Instant dt_update;
	
	//associação com a classe Ticket
	//uma não conformidade pode ser vinculados a vários tickets, e um ticket pode ter mais de uma não conformidade
	@JsonIgnore
	@OneToMany(mappedBy = "type")
	private List <TicketTypeNonConformity> type = new ArrayList<>(); 

	public TypeNonConformities () {
		
	}

	public TypeNonConformities(Long id, String description, Instant dt_created, Instant dt_update,
			List<TicketTypeNonConformity> type) {
		super();
		this.id = id;
		this.description = description;
		this.dt_created = dt_created;
		this.dt_update = dt_update;
		this.type = type;
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

	public List<TicketTypeNonConformity> getType() {
		return type;
	}

	public void setType(List<TicketTypeNonConformity> type) {
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
		TypeNonConformities other = (TypeNonConformities) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
}
