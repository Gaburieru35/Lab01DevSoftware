package com.lab01.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lab01.demo.entities.Usuario;
import com.lab01.demo.repository.UsuarioRepository;

@Configuration
@Profile("test")
public class DataTest implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario("Teste", "teste");		
		
		usuarioRepository.saveAll(Arrays.asList(u1));
	}

}
