package com.lab01.demo.applicaton;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lab01.demo.entities.Aluno;
import com.lab01.demo.entities.Disciplina;
import com.lab01.demo.entities.DisciplinasOfertadas;
import com.lab01.demo.entities.Matricula;
import com.lab01.demo.entities.Professor;
import com.lab01.demo.resources.UsuarioResource;
import com.lab01.demo.service.UsuarioService;

@Component
public class Program {

	@Autowired
	UsuarioService usuarioService;
	
	public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	public static ArrayList<Professor> professores = new ArrayList<Professor>();
	public static ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	public static ArrayList<DisciplinasOfertadas> disciplinasOfertadasList = new ArrayList<DisciplinasOfertadas>();

	public void carregarMenuPrincipal() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Selecione uma das opções do Menu Principal");
		System.out.println("1 - Cadastrar Aluno");
		System.out.println("2 - Cadastrar Professor");
		System.out.println("3 - Cadastrar Disciplina");
		System.out.println("4 - Ofertar Disciplina");

		System.out.println("5 - Matricular na Oferta");
		System.out.println("6 - Cancelar matrícula na Oferta");

		int opcao = sc.nextInt();

		switch (opcao) {
		case 1:
			cadastrarAluno();
			break;
		case 2:
			cadastrarProfessor();
			break;
		case 3:
			cadastrarDisciplina();
			break;
		case 4:
			ofertarDisciplina();
			break;

		case 5:
			matricularNaOferta();
			break;

		case 6:
			cancelarMatricula();
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
	}

	public void cadastrarAluno() {	

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o nome do aluno");
		String nome = sc.nextLine();

		System.out.println("Informe o curso do aluno");
		String curso = sc.nextLine();

		System.out.println("Informe a senha do aluno");
		String senha = sc.nextLine();

		// DUVIDAS NESSA PARTE - Eu seto o id aqui ou automaticamente?
		Long id = new Random().nextLong(100000);
		Matricula mat = new Matricula();

		Aluno aluno = new Aluno(nome, senha, curso, mat);

		alunos.add(aluno);

		usuarioService.insert(aluno);

		System.out.println("Aluno " + aluno.getNome() + " cadastrado com sucesso!");

		carregarMenuPrincipal();
	}

	public void cadastrarProfessor() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o nome do professor");
		String nome = sc.nextLine();

		System.out.println("Informe a senha do professor");
		String senha = sc.nextLine();

		// DUVIDAS NESSA PARTE - Eu seto o id aqui ou automaticamente?
		Long id = new Random().nextLong(100000);

		Professor professor = new Professor(nome, senha);

		professores.add(professor);

		System.out.println("Professor " + professor.getNome() + " cadastrado com sucesso!");

		carregarMenuPrincipal();
	}

	public void cadastrarDisciplina() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o nome da disciplina");
		String nome = sc.nextLine();

		System.out.println("Informe o código da disciplina");
		String codigo = sc.nextLine();

		System.out.println("Informe a quantidade de créditos da disciplina");
		int creditos = sc.nextInt();

		System.out.println("Informe a carga horária da disciplina");
		int cargaHoraria = sc.nextInt();

		Disciplina disciplina = new Disciplina(nome, codigo, creditos, cargaHoraria);

		disciplinas.add(disciplina);

		System.out.println("Disciplina " + disciplina.getName() + " cadastrada com sucesso!");

		carregarMenuPrincipal();
	}

	public void ofertarDisciplina() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe a disciplina");
		listarDisciplinas();
		Disciplina disciplina = disciplinas.get(sc.nextInt());

		if (disciplina.getEstaOfertada()) {
			System.out.println("Disciplina " + disciplina.getName() + " já está ofertada!");
			carregarMenuPrincipal();
		} else {
			disciplina.setEstaOfertada(true);

			System.out.println("Informe o Professor");
			listarProfessores();
			Professor prof = professores.get(sc.nextInt());

			DisciplinasOfertadas disciplinasOfertadas = new DisciplinasOfertadas(disciplina, prof);

			disciplinasOfertadasList.add(disciplinasOfertadas);

			System.out.println("Disciplina " + disciplina.getName() + " ofertada com sucesso!");

			carregarMenuPrincipal();
		}

	}

	public void matricularNaOferta() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe a disciplina");
		listarDisciplinasOfertadas();
		DisciplinasOfertadas discOfert = disciplinasOfertadasList.get(sc.nextInt());

		System.out.println("Informe o aluno");
		listarAlunos();
		Aluno aluno = alunos.get(sc.nextInt());

		if (aluno.getMatricula().getDisciplinas().indexOf(discOfert) != -1) {
			System.out.println("Aluno " + aluno.getNome() + " já está matriculado na disciplina "
					+ discOfert.getDisciplina().getName());
			carregarMenuPrincipal();
		} else {
			if (discOfert.matricularAluno(aluno)) {
				System.out.println("Aluno " + aluno.getNome() + " matriculado com sucesso!");
			} else {
				System.out.println(
						"Disciplina " + discOfert.getDisciplina().getName() + " encerrada por limite de alunos");
			}

			carregarMenuPrincipal();
		}
	}

	public void cancelarMatricula() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe a disciplina");
		listarDisciplinasOfertadas();
		DisciplinasOfertadas discOfert = disciplinasOfertadasList.get(sc.nextInt());

		System.out.println("Informe o aluno");
		listarAlunosPorDisciplinaOfertada(discOfert);
		Aluno aluno = alunos.get(sc.nextInt());

		if (discOfert.cancelarMatricula(aluno)) {
			System.out.println("Aluno " + aluno.getNome() + " cancelado com sucesso!");
		} else {
			System.out.println("Aluno " + aluno.getNome() + " não está matriculado na disciplina "
					+ discOfert.getDisciplina().getName());
		}

		carregarMenuPrincipal();
	}

	public void listarDisciplinas() {
		for (Disciplina disciplina : disciplinas) {

			if (disciplina.getEstaOfertada()) {
				System.out.println(disciplinas.indexOf(disciplina) + " - " + disciplina.getName() + " - Ofertada");
			} else {
				System.out.println(disciplinas.indexOf(disciplina) + " - " + disciplina.getName());
			}
		}
	}

	public void listarProfessores() {
		for (Professor professor : professores) {
			if(professores.isEmpty()) {
				System.out.println("Nenhum professor cadastrado, retornando ao menu principal");
				carregarMenuPrincipal();

				break;
			}

			System.out.println(professores.indexOf(professor) + " - " + professor.getNome());
		}
	}

	public void listarDisciplinasOfertadas() {
		for (DisciplinasOfertadas disciplina : disciplinasOfertadasList) {
			System.out.println(
					disciplinasOfertadasList.indexOf(disciplina) + " - " + disciplina.getDisciplina().getName());
		}
	}

	public void listarAlunos() {
		for (Aluno aluno : alunos) {
			System.out.println(alunos.indexOf(aluno) + " - " + aluno.getNome());
		}
	}

	public void listarAlunosPorDisciplinaOfertada(DisciplinasOfertadas disciplina) {
		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().getDisciplinas().indexOf(disciplina) != -1) {
				System.out.println(alunos.indexOf(aluno) + " - " + aluno.getNome());
			}

			if (alunos.stream().filter(x -> x.getMatricula().getDisciplinas().indexOf(disciplina) != -1).count() == 0) {
				System.out.println("Nenhum aluno matriculado na disciplina " + disciplina.getDisciplina().getName());
				carregarMenuPrincipal();
			}
		}

	}

}