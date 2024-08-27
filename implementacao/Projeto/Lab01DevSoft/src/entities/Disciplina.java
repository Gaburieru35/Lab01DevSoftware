package entities;

public class Disciplina {

	private String name;
	private String codigo;
	private int creditos;
	private int alunosMatriculados;

	public Disciplina() {
	}

	public void matricularAluno(Aluno aluno) {
	}

	public void cancelarMatricula(Aluno aluno) {
	}

	public int verificarMatriculas() {
		return 0;
	}

	public void encerrarDisciplina() {
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

	public int getAlunosMatriculados() {
		return alunosMatriculados;
	}

	public void setAlunosMatriculados(int alunosMatriculados) {
		this.alunosMatriculados = alunosMatriculados;
	}

}
