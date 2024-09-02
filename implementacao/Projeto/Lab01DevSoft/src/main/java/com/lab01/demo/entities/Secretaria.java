package com.lab01.demo.entities;

public class Secretaria extends Usuario {

	public Secretaria(String nome, String senha) {
		super(nome, senha);
	}
	
	public void gerarCurriculo() {}
	
	public void manterInformacoesDisciplina(Disciplina disciplina) {}
	
	public void manterInformacoesProfessor(Professor professor) {}
	
	public void manterInformacoesAluno(Aluno aluno) {}

}