public class Estagiario extends Funcionario implements Trabalhavel {
    private int horas;
    private String supervisor;

    public Estagiario(String nome, String matricula, int horas, String supervisor) {
        super(nome, matricula);
        this.horas = horas;
        this.supervisor = supervisor;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public void trabalhar() {
        System.out.println("Estagiario " + getNome() + " está trabalhando.");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Estagiario " + getNome() + " está relatando progresso.");
    }

    @Override
    public double calcularSalario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularSalario'");
    }

}
