package com.lab01.demo.entities;

import java.io.Serializable;


public class Aluno extends Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String curso;
	private Matricula matricula;

	public Aluno() {
	}

	public Aluno(String nome, String senha, String curso, Matricula matricula) {
		super(nome, senha);
		this.curso = curso;
		this.matricula = matricula;
	}

	private void matricularDisciplina(Disciplina disciplina) {
	}

	private void cancelarMatricula(Disciplina disciplina) {
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

}