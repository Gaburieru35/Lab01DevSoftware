package com.lab01.demo.entities;

public class Usuario {

	private String nome;
	private int id;
	private String senha;

	public Usuario() {
	}

	public Usuario(String nome, int id, String senha) {
		this.nome = nome;
		this.id = id;
		this.senha = senha;
	}

	public void realizarLogin() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}