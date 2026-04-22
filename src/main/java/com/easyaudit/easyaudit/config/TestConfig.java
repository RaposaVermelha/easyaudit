package com.easyaudit.easyaudit.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.easyaudit.easyaudit.entities.User;
import com.easyaudit.easyaudit.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	//incia os metodos automaticamente quando a aplicação iniciar, útil para o seeding do banco de dados.
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Raposo", "admin1998", "raposo@gmail.com");
		User user2 = new User(null, "Chico", "user123", "chico@hotmail.com");
		
		//usando repositório para salvar no banco de dados
		userRepository.saveAll(Arrays.asList(user1, user2));
		
	}

}
