import java.util.ArrayList;

public class Desenvolvedor extends Funcionario implements Trabalhavel {
    private ArrayList<String> tecnologias;

    public Desenvolvedor(String nome, String matricula, ArrayList<String> tecnologias) {
        super(nome, matricula);
        this.tecnologias = tecnologias;
    }

    public ArrayList<String> getTecnologias() {
        return tecnologias;
    }

    public void adicionarTecnologia(String tecnologia) {
        tecnologias.add(tecnologia);
    }

    public void removerTecnologia(String tecnologia) {
        tecnologias.remove(tecnologia);
    }

    @Override
    public double calcularSalario() {
        // Implementação do cálculo do salário para desenvolvedores
        // Exemplo: salário base + bônus por tecnologias dominadas
        return 4000 + (tecnologias.size() * 500);
    }

    @Override
    public void trabalhar() {
        System.out.println("Desenvolvedor " + getNome() + " está trabalhando em projetos.");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Desenvolvedor " + getNome() + " está relatando progresso.");
    }
}
