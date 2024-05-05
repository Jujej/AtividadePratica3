import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void executar() {
        Sistema sistema = new Sistema();
        int opcao;
        do {
            System.out.println("\nSelecione a opção:");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Remover Funcionário");
            System.out.println("3. Exibir Todos os Funcionários");
            System.out.println("4. Buscar Funcionário por Nome");
            System.out.println("5. Buscar Funcionário por Matrícula");
            System.out.println("6. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    sistema.adicionarFuncionario();
                    break;
                case 2:
                    sistema.removerFuncionario();
                    break;
                case 3:
                    sistema.exibirFuncionarios();
                    break;
                case 4:
                    sistema.buscarPorNome();
                    break;
                case 5:
                    sistema.buscarPorMatricula();
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);
    }

    private void adicionarFuncionario() {
        System.out.println("Selecione o tipo de funcionário:");
        System.out.println("1. Gerente");
        System.out.println("2. Desenvolvedor");
        System.out.println("3. Estagiário");

        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.println("Digite o nome do funcionário:");
        String nome = scanner.nextLine();

        System.out.println("Digite a matrícula do funcionário:");
        String matricula = scanner.nextLine();

        switch (tipo) {
            case 1:
                System.out.println("Digite o bônus anual:");
                double bonusAnual = scanner.nextDouble();
                scanner.nextLine(); // Limpar o buffer

                System.out.println("Digite a equipe sob gerência:");
                String equipe = scanner.nextLine();

                funcionarios.add(new Gerente(nome, matricula, bonusAnual, equipe));
                break;
            case 2:
                ArrayList<String> tecnologias = new ArrayList<>();
                while (true) {
                    System.out.println("Digite uma tecnologia que o desenvolvedor domina (ou 'fim' para parar):");
                    String tecnologia = scanner.nextLine();
                    if (tecnologia.equalsIgnoreCase("fim")) break;
                    tecnologias.add(tecnologia);
                }

                funcionarios.add(new Desenvolvedor(nome, matricula, tecnologias));
                break;
            case 3:
                System.out.println("Digite o número de horas de trabalho:");
                int horasTrabalhadas = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                System.out.println("Digite o nome do supervisor:");
                String supervisor = scanner.nextLine();

                funcionarios.add(new Estagiario(nome, matricula, horasTrabalhadas, supervisor));
                break;
            default:
                System.out.println("Tipo de funcionário inválido.");
        }

        System.out.println("Funcionário adicionado com sucesso!");
    }

    private void removerFuncionario() {
        System.out.println("Digite a matrícula do funcionário a ser removido:");
        String matricula = scanner.nextLine();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula().equals(matricula)) {
                funcionarios.remove(funcionario);
                System.out.println("Funcionário removido com sucesso!");
                return;
            }
        }
        System.out.println("Funcionário com a matrícula especificada não encontrado.");
    }

    private void exibirFuncionarios() {
        System.out.println("Lista de funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - " + funcionario.getMatricula());
        }
    }

    private void buscarPorNome() {
        System.out.println("Digite o nome do funcionário:");
        String nome = scanner.nextLine();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Funcionário encontrado:");
                System.out.println(funcionario.getNome() + " - " + funcionario.getMatricula());
                return;
            }
        }
        System.out.println("Funcionário com o nome especificado não encontrado.");
    }

    private void buscarPorMatricula() {
        System.out.println("Digite a matrícula do funcionário:");
        String matricula = scanner.nextLine();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula().equals(matricula)) {
                System.out.println("Funcionário encontrado:");
                System.out.println(funcionario.getNome() + " - " + funcionario.getMatricula());
                return;
            }
        }
        System.out.println("Funcionário com a matrícula especificada não encontrado.");
    }
}
