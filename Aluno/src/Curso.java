import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {
    private String nomeCurso;
    private List<Aluno> alunos; //listaDeAlunos (lista de objetos Aluno)

    Scanner scanner = new Scanner(System.in); //scanner

    public Curso(String nomeCurso) { //construtor
        this.nomeCurso = nomeCurso;
        alunos = new ArrayList<>();
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
    }
    public List<Aluno> getListaDeAlunos() {
        return alunos;
    }
    public void buscarAlunoPorMatricula(){
        System.out.println("Informe a matricula do aluno: ");
        String matricula = scanner.nextLine();
        for (Aluno a : alunos) {
            if(a.getMatricula().equals(matricula)){
                System.out.println("Aluno encontrado: " + a);
                return;
            }
        }
    }
}
