package com.lab01.demo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_disciplinas_ofertadas")
public class DisciplinasOfertadas implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Disciplina disciplina;
    private Date prazo;
    private boolean status = true;
    private Professor professor;

    public DisciplinasOfertadas(Disciplina disciplina, Professor professor){
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public boolean matricularAluno(Aluno aluno){
        if(!verificarLimite()){
            aluno.getMatricula().matricularAlunoNaDisciplina(this);
            return true;
        }else{
            encerrarDisciplina();
            return false;
        }
    }

	public boolean cancelarMatricula(Aluno aluno) {
        if(aluno.getMatricula().getQuantidadeMatriculas() > 0){
            if(aluno.getMatricula().desmatricularAluno(this)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
	}

    //Retorna true se o limite estiver sido ultrapassado
    private boolean verificarLimite() {
		return this.disciplina.getLimite() > 60;
	}

    public void encerrarDisciplina() {
        if(verificarLimite()){ this.status = false; }
	}

    public Professor getProfessor(){
		return this.professor;
	}

	public void setProfessor(Professor professor){
		this.professor = professor;
	}

    public Disciplina getDisciplina(){
        return this.disciplina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}