import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static List<Curso> listaCursos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 Criar novo curso");
            System.out.println("2 Listar cursos disponíveis");
            System.out.println("3 Cadastrar aluno em um curso");
            System.out.println("4 Listar alunos de um curso específico");
            System.out.println("5 Buscar aluno por matrícula em um curso");
            System.out.println("6 Remover aluno por matrícula em um curso");
            System.out.println("7 Sair do sistema");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do novo curso: ");
                    String nomeCurso = scanner.nextLine();
                    listaCursos.add(new Curso(nomeCurso));
                    System.out.println("Curso " + nomeCurso + " criado com sucesso!");
                    break;

                case 2:
                    if (listaCursos.isEmpty()) {
                        System.out.println("Nenhum curso disponivel! ");
                    } else {
                        for (Curso c : listaCursos) {
                            System.out.println(c.getNomeCurso());
                        }
                    }
                    break;

                case 3:
                    if (listaCursos.isEmpty()) {
                        System.out.println("\n Nenhum curso disponível! Crie um curso primeiro.\n");
                    } else {
                        System.out.println("Digite o nome do curso para cadastrar o aluno: ");
                        String cursoAluno = scanner.nextLine();

                        Curso cursoSelecionado = null;

                        for (Curso c : listaCursos) {
                            if (c.getNomeCurso().equalsIgnoreCase(cursoAluno)) {
                                cursoSelecionado = c;
                                break;
                            }
                        }
                        if (cursoSelecionado == null) {
                            System.out.println("Curso não encontrado.");
                            break;
                        }
                        System.out.print("Nome do aluno: ");
                        String nome = scanner.nextLine();
                        System.out.print("Matrícula do aluno: ");
                        String matricula = scanner.nextLine();
                        System.out.print("Nota do aluno: ");
                        double nota = scanner.nextDouble();
                        scanner.nextLine();

                        cursoSelecionado.adicionarAluno(new Aluno(nome, matricula, nota));
                        System.out.println("Aluno cadastrado com sucesso!");

                    }
                    break;

                case 4:
                    if (listaCursos.isEmpty()) {
                        System.out.println("NENHUM CURSO CADASTRADO");
                        break;
                    }
                    System.out.print("Digite o nome do curso: ");
                    String nomeCursoLista = scanner.nextLine();
                    for (Curso c : listaCursos) {
                        if (c.getNomeCurso().equalsIgnoreCase(nomeCursoLista)) {
                            if (c.getListaDeAlunos().isEmpty()) {
                                System.out.println("Nenhum aluno cadastrado neste curso.");
                            } else {
                                for (Aluno a : c.getListaDeAlunos()) {
                                    System.out.println("Alunos: " + a);
                                }
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.print("Digite o nome do curso: ");
                    String nomeCursoBusca = scanner.nextLine();
                    System.out.print("Digite a matrícula do aluno: ");
                    String matriculaBusca = scanner.nextLine();
                    for (Curso c : listaCursos) {
                        if (c.getNomeCurso().equalsIgnoreCase(nomeCursoBusca)) {
                            for (Aluno aluno : c.getListaDeAlunos()) {
                                if (aluno.getMatricula().equalsIgnoreCase(matriculaBusca)) {
                                    System.out.println(aluno);
                                }
                            }
                        }
                    }
                    break;

                case 6:
                    if(listaCursos.isEmpty()){
                        System.out.println("Nenhum curso cadastrado!");
                        break;
                    }
                    System.out.print("Digite o nome do curso: ");
                    String nomeCursoRemover = scanner.nextLine();
                    for (Curso c : listaCursos) {
                        if (c.getNomeCurso().equalsIgnoreCase(nomeCursoRemover)) {
                            c.removerAlunoPorMatricula();
                            break;
                        }
                    }
                        break;
                case 7:
                    sair = true;
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
