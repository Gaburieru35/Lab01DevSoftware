package com.lab01.demo.applicaton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lab01.demo")
public class MainApp {
        public static void main(String[] args) {
            // Inicia o contexto da aplicação Spring
        ApplicationContext context = SpringApplication.run(MainApp.class, args);

        // Obtém a instância de Program gerenciada pelo Spring
        Program pr = context.getBean(Program.class);

        // Carrega o menu principal
        pr.carregarMenuPrincipal();
        }
}
