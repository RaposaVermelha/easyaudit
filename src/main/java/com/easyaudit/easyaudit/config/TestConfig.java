package com.easyaudit.easyaudit.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.easyaudit.easyaudit.entities.StatusNonConformities;
import com.easyaudit.easyaudit.entities.Ticket;
import com.easyaudit.easyaudit.entities.TicketTypeNonConformity;
import com.easyaudit.easyaudit.entities.TypeNonConformities;
import com.easyaudit.easyaudit.entities.User;
import com.easyaudit.easyaudit.repositories.StatusNonConformitiesRepository;
import com.easyaudit.easyaudit.repositories.TicketRepository;
import com.easyaudit.easyaudit.repositories.TicketTypeNonConformityRepository;
import com.easyaudit.easyaudit.repositories.TypeNonConformitiesRepository;
import com.easyaudit.easyaudit.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private StatusNonConformitiesRepository statusRepository;
	
	@Autowired
	private TypeNonConformitiesRepository typeRepository;
	
	@Autowired
	private TicketTypeNonConformityRepository ticketTypeRepository;
	
	//incia os metodos automaticamente quando a aplicação iniciar, útil para o seeding do banco de dados.
	@Override
	public void run(String... args) throws Exception {
		
		// 👤 usuários
	    User user1 = new User(null, "Raposo", "admin1998", "raposo@gmail.com");
	    User user2 = new User(null, "Chico", "user123", "chico@hotmail.com");
	    userRepository.saveAll(Arrays.asList(user1, user2));

	    // ⚠️ tipo de não conformidade
	    TypeNonConformities type1 = new TypeNonConformities(
	        null,
	        "Sem Foto ID (Frente)",
	        Instant.parse("2026-04-24T21:12:10Z"),
	        null,
	        null
	    );

	    TypeNonConformities type2 = new TypeNonConformities(
	        null,
	        "Sem Foto CTO",
	        Instant.now(),
	        null,
	        null
	    );

	    typeRepository.saveAll(Arrays.asList(type1, type2));

	    // 📊 status
	    StatusNonConformities status1 = new StatusNonConformities(
	        null,
	        "Reprovado Parcial",
	        Instant.now(),
	        null,
	        null
	    );

	    statusRepository.save(status1);

	    // 🎫 ticket
	    Ticket ticket1 = new Ticket(
	        null,
	        "1254",
	        "Maria Menezes",
	        "5541",
	        "5539",
	        "Resolvido",
	        "INSTALAÇÃO",
	        Instant.now(),
	        "Serviço Habilitado",
	        "Raposo_Comercial_AM",
	        Instant.now(),
	        null,
	        status1,
	        null, // não usa mais lista direta
	        user1
	    );

	    ticketRepository.save(ticket1);

	    // 🔗 vínculo 1
	    TicketTypeNonConformity link1 = new TicketTypeNonConformity();
	    link1.setTicket(ticket1);
	    link1.setType(type1);
	    link1.setAuditor(user1);
	    link1.setDt_created(Instant.now());

	    // 🔗 vínculo 2 (mesmo ticket, outra não conformidade)
	    TicketTypeNonConformity link2 = new TicketTypeNonConformity();
	    link2.setTicket(ticket1);
	    link2.setType(type2);
	    link2.setAuditor(user2);
	    link2.setDt_created(Instant.now());

	    ticketTypeRepository.saveAll(Arrays.asList(link1, link2));
		
	}

}
