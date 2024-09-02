package com.lab01.demo.entities;

public class Secretaria extends Usuario {

	public Secretaria(String nome, int id, String senha) {
		super(nome, id, senha);
	}
	
	public void gerarCurriculo() {}
	
	public void manterInformacoesDisciplina(Disciplina disciplina) {}
	
	public void manterInformacoesProfessor(Professor professor) {}
	
	public void manterInformacoesAluno(Aluno aluno) {}

}