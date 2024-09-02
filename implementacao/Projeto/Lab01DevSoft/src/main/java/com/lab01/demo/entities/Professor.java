package com.lab01.demo.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class Professor extends Usuario  {

	

	

	private Long Id;

	public Professor() {
	}

	public Professor(String nome, String senha) {
		super(nome,  senha);
	}

	public void verificarAlunos(Disciplina disciplina) {
	}
}