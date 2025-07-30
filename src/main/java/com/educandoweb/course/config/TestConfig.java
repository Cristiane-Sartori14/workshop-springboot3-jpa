package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { /*permite executar o código assim que a 
* aplicação Spring Boot é iniciada. O método `run()` é chamado automaticamente após o carregamento
*do contexto da aplicação.*/
	
	@Autowired /*Anotação do Spring que injeta automaticamente a dependência do UserRepository. 
	*Isso significa que o Spring fornece uma instância dessa interface sem você precisar criar com new*/
	private UserRepository userRepository; /* permite acessar o banco de dados para operações com a entidade User.*/

	@Override /*sobrescrevendo o método da interface `CommandLineRunner`*/
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	

	
}
