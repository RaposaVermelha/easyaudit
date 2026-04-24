package com.easyaudit.easyaudit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyaudit.easyaudit.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
