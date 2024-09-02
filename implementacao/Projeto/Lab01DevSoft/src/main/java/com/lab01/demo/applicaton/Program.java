package com.lab01.demo.applicaton;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.lab01.demo.entities.Aluno;
import com.lab01.demo.entities.Disciplina;
import com.lab01.demo.entities.DisciplinasOfertadas;
import com.lab01.demo.entities.Matricula;
import com.lab01.demo.entities.Professor;

public class Program {

	public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	public static ArrayList<Professor> professores = new ArrayList<Professor>();
	public static ArrayList<Disciplina> disciplinas  = new ArrayList<Disciplina>();
	public static ArrayList<DisciplinasOfertadas> disciplinasOfertadasList  = new ArrayList<DisciplinasOfertadas>();
	public static void main(String[] args) {
		
		carregarMenuPrincipal();

	}

	public static void carregarMenuPrincipal(){

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

	public static void cadastrarAluno(){
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o nome do aluno");
		String nome = sc.nextLine();

		System.out.println("Informe o curso do aluno");
		String curso = sc.nextLine();

		System.out.println("Informe a senha do aluno");
		String senha = sc.nextLine();

		int id = new Random().nextInt(100000);
		Matricula mat = new Matricula();

		Aluno aluno = new Aluno(nome, id, senha, curso, mat);

		alunos.add(aluno);

		System.out.println("Aluno "+aluno.getNome()+" cadastrado com sucesso!");

		carregarMenuPrincipal();
	}

	public static void cadastrarProfessor(){

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o nome do professor");
		String nome = sc.nextLine();

		System.out.println("Informe a senha do professor");
		String senha = sc.nextLine();

		int id = new Random().nextInt(100000);

		Professor professor = new Professor(nome, id, senha);

		professores.add(professor);

		System.out.println("Professor "+professor.getNome()+" cadastrado com sucesso!");

		carregarMenuPrincipal();
	}

	public static void cadastrarDisciplina(){
		
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

		System.out.println("Disciplina "+disciplina.getName()+" cadastrada com sucesso!");

		carregarMenuPrincipal();
	}

	public static void ofertarDisciplina(){
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe a disciplina");
		listarDisciplinas();
		Disciplina disciplina = disciplinas.get(sc.nextInt());

		if(disciplina.getEstaOfertada()){
			System.out.println("Disciplina "+disciplina.getName()+" já está ofertada!");
			carregarMenuPrincipal();
		} else {
			disciplina.setEstaOfertada(true);

			System.out.println("Informe o Professor");
			listarProfessores();
			Professor prof = professores.get(sc.nextInt());
	
			DisciplinasOfertadas disciplinasOfertadas = new DisciplinasOfertadas(disciplina, prof);
	
			disciplinasOfertadasList.add(disciplinasOfertadas);
	
			System.out.println("Disciplina "+disciplina.getName()+" ofertada com sucesso!");
	
			carregarMenuPrincipal();
		}
		
	}

	public static void matricularNaOferta(){
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe a disciplina");
		listarDisciplinasOfertadas();
		DisciplinasOfertadas discOfert = disciplinasOfertadasList.get(sc.nextInt());

		System.out.println("Informe o aluno");
		listarAlunos();
		Aluno aluno = alunos.get(sc.nextInt());

		if(aluno.getMatricula().getDisciplinas().indexOf(discOfert) != -1){
			System.out.println("Aluno "+aluno.getNome()+" já está matriculado na disciplina "+discOfert.getDisciplina().getName());
			carregarMenuPrincipal();
		} else {
			if(discOfert.matricularAluno(aluno)){
				System.out.println("Aluno "+aluno.getNome()+" matriculado com sucesso!");
			}else{
				System.out.println("Disciplina "+discOfert.getDisciplina().getName()+" encerrada por limite de alunos");
			}
	
			carregarMenuPrincipal();
		}		
	}

	public static void cancelarMatricula(){
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe a disciplina");
		listarDisciplinasOfertadas();
		DisciplinasOfertadas discOfert = disciplinasOfertadasList.get(sc.nextInt());

		System.out.println("Informe o aluno");
		listarAlunosPorDisciplinaOfertada(discOfert);
		Aluno aluno = alunos.get(sc.nextInt());

		if(discOfert.cancelarMatricula(aluno)){
			System.out.println("Aluno "+aluno.getNome()+" cancelado com sucesso!");
		}else{
			System.out.println("Aluno "+aluno.getNome()+" não está matriculado na disciplina "+discOfert.getDisciplina().getName());
		}

		carregarMenuPrincipal();
	}

	public static void listarDisciplinas(){
		for(Disciplina disciplina : disciplinas){

			if(disciplina.getEstaOfertada()){
				System.out.println(disciplinas.indexOf(disciplina)+" - "+disciplina.getName()+" - Ofertada");
			} else {
				System.out.println(disciplinas.indexOf(disciplina)+" - "+disciplina.getName());
			}	
		}
	}

	public static void listarProfessores(){
		for(Professor professor : professores){
			System.out.println(professores.indexOf(professor)+" - "+professor.getNome());
		}
	}

	public static void listarDisciplinasOfertadas(){
		for(DisciplinasOfertadas disciplina : disciplinasOfertadasList){
			System.out.println(disciplinasOfertadasList.indexOf(disciplina)+" - "+disciplina.getDisciplina().getName());
		}
	}

	public static void listarAlunos(){
		for(Aluno aluno : alunos){
			System.out.println(alunos.indexOf(aluno)+" - "+aluno.getNome());
		}
	}

	public static void listarAlunosPorDisciplinaOfertada(DisciplinasOfertadas disciplina){
		for(Aluno aluno : alunos){
			if(aluno.getMatricula().getDisciplinas().indexOf(disciplina) != -1){
				System.out.println(alunos.indexOf(aluno)+" - "+aluno.getNome());
			}

			if(alunos.stream().filter(x -> x.getMatricula().getDisciplinas().indexOf(disciplina) != -1).count() == 0){
				System.out.println("Nenhum aluno matriculado na disciplina "+disciplina.getDisciplina().getName());
				carregarMenuPrincipal();
			}
		}

	}
}