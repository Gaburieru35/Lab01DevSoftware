package com.lab01.demo.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_disciplina")
public class Disciplina implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String name;
	private String codigo;
	private int creditos;
	private int cargaHoraria;
	private int limite;
	private boolean estaOfertada = false;

	public Disciplina(String name, String codigo, int creditos, int cargaHoraria) {
		this.name = name;
		this.codigo = codigo;
		this.creditos = creditos;
		this.cargaHoraria = cargaHoraria;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getCargaHoraria(){
		return this.cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria){
		this.cargaHoraria = cargaHoraria;
	}

	public int getLimite(){
		return this.limite;
	}

	public void setLimite(int limite){
		this.limite = limite;
	}

	public boolean getEstaOfertada(){
		return this.estaOfertada;
	}

	public void setEstaOfertada(boolean estaOfertada){
		this.estaOfertada = estaOfertada;
	}

}