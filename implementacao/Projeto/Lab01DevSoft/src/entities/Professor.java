package entities;

public class Professor extends Usuario {

	public Professor() {
	}

	public Professor(String nome, int id, String senha, Disciplina disciplina) {
		super(nome, id, senha);
	}

	public void verificarAlunos(Disciplina disciplina) {
	}
}
