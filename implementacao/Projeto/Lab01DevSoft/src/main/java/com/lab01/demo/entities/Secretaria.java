package com.lab01.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_secretaria")
public class Secretaria extends Usuario {

	private static final long serialVersionUID = 1L;

	public Secretaria(String nome, String senha) {
		super(nome, senha);
	}
	
	public void gerarCurriculo() {}
	
	public void manterInformacoesDisciplina(Disciplina disciplina) {}
	
	public void manterInformacoesProfessor(Professor professor) {}
	
	public void manterInformacoesAluno(Aluno aluno) {}

}