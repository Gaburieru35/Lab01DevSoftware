package entities;

public class Professor extends Usuario {

	private Disciplina disciplina;

	public Professor() {
	}

	public Professor(String nome, int id, String senha, Disciplina disciplina) {
		super(nome, id, senha);
		this.disciplina = disciplina;
	}

	public void verificarAlunos(Disciplina disciplina) {
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
