package control;

import entities.Aluno;
import entities.Curso;
import repository.AlunoRepository;
import repository.CursoRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        AlunoRepository alunoRepository = new AlunoRepository();
        CursoRepository cursoRepository = new CursoRepository();
        try {
            Scanner scanner = new Scanner(System.in);

            int menu = 0;

            System.out.println("Digite 1 para Cadastrar aluno");
            System.out.println("Digite 2 para Cadastrar curso");
            System.out.println("Digite 3 para exibir todos os alunos");
            System.out.println("Digite 4 para exibir alunos de um curso");
            menu = scanner.nextInt();
            switch (menu) {
                case (1):

                    System.out.println("Digite o nome do aluno:");
                    String nome = scanner.nextLine();

                    System.out.println("Insira o codigo do curso do Aluno: ");
                    String cod_curso = scanner.nextLine();

                    Aluno aluno = new Aluno(nome, null);
                    alunoRepository.inserirAluno(emf,aluno);
                    break;
                case (2):
                    System.out.println("Insira o nome do Curso: ");
                    String nomeCurso = scanner.nextLine();
                    System.out.println("Insira a carga horária do Curso: ");
                    int chCurso = scanner.nextInt();
                    Curso curso = new Curso(null, nomeCurso, chCurso);
                    cursoRepository.inserirCurso(emf,curso);
                    break;
                case(3):
                    System.out.println("Lista de alunos");
                    alunoRepository.mostrarAluno(emf);
                    break;
                case(4):
                    System.out.println("Digite o nome do curso");
                    String escolha = scanner.nextLine();
                    alunoRepository.exibirAlunosdeCurso(emf,escolha);
                    break;
                }
            } catch (Exception e) {

                e.printStackTrace();
        }
    }
}
