package com.lab01.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_professor")
public class Professor extends Usuario  {


	private static final long serialVersionUID = 1L;

	public Professor() {
	}

	public Professor(String nome, String senha) {
		super(nome, senha);
	}

	public void verificarAlunos(Disciplina disciplina) {
	}
}