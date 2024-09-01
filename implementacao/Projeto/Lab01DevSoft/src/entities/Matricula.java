package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Matricula {

	private Date data;
	private boolean status = true;
	private String tipo;
	private ArrayList<DisciplinasOfertadas> disciplinas = new ArrayList<DisciplinasOfertadas>();

	public Matricula() {
	}

	private void notificarCobranca() {
	}

	public boolean matricularAlunoNaDisciplina(DisciplinasOfertadas disciplinaConfirmada){
		if(disciplinas.indexOf(disciplinaConfirmada) == -1){
			this.disciplinas.add(disciplinaConfirmada);
			return true;
		}	
		return false;
	}

	public boolean desmatricularAluno(DisciplinasOfertadas disciplinaConfirmada){
		int disciplinaEncontrada = this.disciplinas.indexOf(disciplinaConfirmada);
		if(disciplinaEncontrada != -1){
			disciplinas.remove(disciplinaEncontrada);
			return true;
		}else{
			return false;
		}
	}

	//getter/setter
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

	public int getQuantidadeMatriculas(){
		return this.disciplinas.size();
	}

	public ArrayList<DisciplinasOfertadas> getDisciplinas() {
		return disciplinas;
	}
}
