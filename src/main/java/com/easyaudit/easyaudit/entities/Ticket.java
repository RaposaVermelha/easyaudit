package com.easyaudit.easyaudit.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ticket")
public class Ticket implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String id_ticket_hub;
	private String client_name_hub;
	private String client_cod_hub;
	private String client_id_hub;
	private String status_ticket_hub;
	private String type_ticket_hub;
	private Instant date_finished_ticket_hub;
	private String status_service_client_hub;
	//quem foi auditado -> informação também vem no json do hubsoft.
	private String answerable_ticket_hub;
	//campos do proprio sistema (não virão pela api, mas ficarão salvos no banco de dados)
	private Instant audit_date;
	private Instant audit_date_update;
	
	//associações
	//status da autidoria: aprovado, nao_conformidade aprovada, reprovado parcial, reprovado
	//um atendimento tem UM ÚNICO status, o usuario vai poder remover e adicionar , mas somente um tipo por vez.
	
	@ManyToOne
	@JoinColumn(name = "non_conformitie_id")
	private StatusNonConformities status;
	
	// tipo de não conformidade aplicada, ex: sem foto do rg, sem fotos da cto no poste, etc;
	//pode haver mais de um tipo por atendimento, e o usuario vai poder remover e adicionar, vários de uma vez.
	@OneToMany(mappedBy = "ticket")
	private List<TicketTypeNonConformity> typeLinks = new ArrayList<>();
	
	//quem auditou
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User auditor;
	
	public Ticket () {
		
	}

	public Ticket(Long id, String id_ticket_hub, String client_name_hub, String client_cod_hub, String client_id_hub,
			String status_ticket_hub, String type_ticket_hub, Instant date_finished_ticket_hub,
			String status_service_client_hub, String answerable_ticket_hub, Instant audit_date,
			Instant audit_date_update, StatusNonConformities status, List<TicketTypeNonConformity> typeLinks,
			User auditor) {
		super();
		this.id = id;
		this.id_ticket_hub = id_ticket_hub;
		this.client_name_hub = client_name_hub;
		this.client_cod_hub = client_cod_hub;
		this.client_id_hub = client_id_hub;
		this.status_ticket_hub = status_ticket_hub;
		this.type_ticket_hub = type_ticket_hub;
		this.date_finished_ticket_hub = date_finished_ticket_hub;
		this.status_service_client_hub = status_service_client_hub;
		this.answerable_ticket_hub = answerable_ticket_hub;
		this.audit_date = audit_date;
		this.audit_date_update = audit_date_update;
		this.status = status;
		this.typeLinks = typeLinks;
		this.auditor = auditor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getId_ticket_hub() {
		return id_ticket_hub;
	}

	public void setId_ticket_hub(String id_ticket_hub) {
		this.id_ticket_hub = id_ticket_hub;
	}

	public String getClient_name_hub() {
		return client_name_hub;
	}

	public void setClient_name_hub(String client_name_hub) {
		this.client_name_hub = client_name_hub;
	}

	public String getClient_cod_hub() {
		return client_cod_hub;
	}

	public void setClient_cod_hub(String client_cod_hub) {
		this.client_cod_hub = client_cod_hub;
	}

	public String getClient_id_hub() {
		return client_id_hub;
	}

	public void setClient_id_hub(String client_id_hub) {
		this.client_id_hub = client_id_hub;
	}

	public String getStatus_ticket_hub() {
		return status_ticket_hub;
	}

	public void setStatus_ticket_hub(String status_ticket_hub) {
		this.status_ticket_hub = status_ticket_hub;
	}

	public String getType_ticket_hub() {
		return type_ticket_hub;
	}

	public void setType_ticket_hub(String type_ticket_hub) {
		this.type_ticket_hub = type_ticket_hub;
	}

	public Instant getDate_finished_ticket_hub() {
		return date_finished_ticket_hub;
	}

	public void setDate_finished_ticket_hub(Instant date_finished_ticket_hub) {
		this.date_finished_ticket_hub = date_finished_ticket_hub;
	}

	public String getStatus_service_client_hub() {
		return status_service_client_hub;
	}

	public void setStatus_service_client_hub(String status_service_client_hub) {
		this.status_service_client_hub = status_service_client_hub;
	}

	public String getAnswerable_ticket_hub() {
		return answerable_ticket_hub;
	}

	public void setAnswerable_ticket_hub(String answerable_ticket_hub) {
		this.answerable_ticket_hub = answerable_ticket_hub;
	}

	public Instant getAudit_date() {
		return audit_date;
	}

	public void setAudit_date(Instant audit_date) {
		this.audit_date = audit_date;
	}

	public Instant getAudit_date_update() {
		return audit_date_update;
	}

	public void setAudit_date_update(Instant audit_date_update) {
		this.audit_date_update = audit_date_update;
	}

	public StatusNonConformities getStatus() {
		return status;
	}

	public void setStatus(StatusNonConformities status) {
		this.status = status;
	}

	public List<TicketTypeNonConformity> getTypeLinks() {
		return typeLinks;
	}

	public void setTypeLinks(List<TicketTypeNonConformity> typeLinks) {
		this.typeLinks = typeLinks;
	}

	public User getAuditor() {
		return auditor;
	}

	public void setAuditor(User auditor) {
		this.auditor = auditor;
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
		Ticket other = (Ticket) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
}
