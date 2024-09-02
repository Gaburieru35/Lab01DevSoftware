package com.lab01.demo.entities;

import java.util.Date;

public class DisciplinasOfertadas {
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
}