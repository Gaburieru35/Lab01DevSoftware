package com.lab01.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_matricula")
public class Matricula implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date data;
	private boolean status = true;
	private String tipo;
	@Lob
	private ArrayList<DisciplinasOfertadas> disciplinas = new ArrayList<DisciplinasOfertadas>();

	public Matricula() {
	}

	private void notificarCobranca() {
	}

	public boolean matricularAlunoNaDisciplina(DisciplinasOfertadas disciplinaConfirmada) {
		if (disciplinas.indexOf(disciplinaConfirmada) == -1) {
			this.disciplinas.add(disciplinaConfirmada);
			return true;
		}
		return false;
	}

	public boolean desmatricularAluno(DisciplinasOfertadas disciplinaConfirmada) {
		int disciplinaEncontrada = this.disciplinas.indexOf(disciplinaConfirmada);
		if (disciplinaEncontrada != -1) {
			disciplinas.remove(disciplinaEncontrada);
			return true;
		} else {
			return false;
		}
	}

	// getter/setter
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQuantidadeMatriculas() {
		return this.disciplinas.size();
	}

	public ArrayList<DisciplinasOfertadas> getDisciplinas() {
		return disciplinas;
	}
}