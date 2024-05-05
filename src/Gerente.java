public class Gerente extends Funcionario implements Trabalhavel {
    private double bonusAnual;
    private String equipe;

    public Gerente(String nome, String matricula, double bonusAnual, String equipe) {
        super(nome, matricula);
        this.bonusAnual = bonusAnual;
        this.equipe = equipe;
    }

    public double getBonusAnual() {
        return bonusAnual;
    }

    public void setBonusAnual(double bonusAnual) {
        this.bonusAnual = bonusAnual;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    @Override
    public double calcularSalario() {
        // Implementação do cálculo do salário para gerentes
        // Exemplo: salário base + bônus anual
        return 5000 + bonusAnual;
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerente " + getNome() + " está gerenciando sua equipe.");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Gerente " + getNome() + " está relatando progresso.");
    }
}
