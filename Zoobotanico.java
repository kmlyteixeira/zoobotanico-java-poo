import java.util.Scanner;

public class Zoobotanico {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op = 0;

        System.out.println("==================================");
        System.out.println("========== ZOOBOTÂNICO ===========");
        System.out.println("==================================");

        do {
            System.out.println("01 - Cadastrar Jaulas");
            System.out.println("02 - Cadastrar Animais");
            System.out.println("03 - Cadastrar Alimentação para um Animal");
            System.out.println("04 - Listar Jaulas");
            System.out.println("05 - Listar Animais");
            System.out.println("06 - Listar Alimentação");
            System.out.println("07 - Excluir Jaula");
            System.out.println("08 - Excluir Animal");
            System.out.println("09 - Excluir Alimentação");
            System.out.println("10 - Sair");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    CadastrarJaula(sc);
                    break;

                case 2:
                    CadastrarAnimal(sc);
                    break;

                case 3:
                    CadastrarAlimentacao(sc);
                    break;

                case 4:
                    ListarJaulas();
                    break;

                case 5:
                    ListarAnimais();
                    break;

                case 6:
                    ListarAlimentacoes();
                    break;

                case 7:
                    // ExcluirJaula(sc);
                    break;

                case 8:
                    // ExcluirAnimal(sc);
                    break;

                case 9:
                    // ExcluirAlimentacao(sc);
                    break;

                case 10:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (op != 10);
    }

    public static void CadastrarJaula(Scanner sc) {
        System.out.println("==== Cadastro de Jaulas ====");
        System.out.println("Informe o nome da jaula: ");
        String nomeJaula = sc.next();

        System.out.println("Informe o tipo da jaula: [M] Mamíferos | [R] Répteis | [A] Aves");
        String tipoJaula = sc.next();

        Jaula jaula = new Jaula(Jaula.jaulas.size() + 1, nomeJaula, tipoJaula);
        System.out.println("Jaula " + jaula.nome + " cadastrada!");
    }

    public static void CadastrarAnimal(Scanner sc) {
        System.out.println("==== Cadastro de Animais ====");
        System.out.println("Informe o nome do animal: ");
        String nomeAnimal = sc.next();
        System.out.println("Informe a espécie do animal: ");
        String especieAnimal = sc.next();
        int valida = 0;
        String tipoAnimal = "";
        System.out.println("Informe o tipo da Animal: [M] Mamíferos | [R] Répteis | [A] Aves");
        do {
            tipoAnimal = sc.next();
            switch (tipoAnimal) {
                case "M":
                    System.out.println("Informe o tempo de gestação: ");
                    String tempoGestacao = sc.next();
                    System.out.println("Informe o ID da Jaula: ");
                    int idJaulaMam = sc.nextInt();
                    Jaula jaulaMam = Jaula.getJaulaById(idJaulaMam);
                    Mamiferos mamifero = new Mamiferos(Mamiferos.mamiferos.size() + 1, nomeAnimal, especieAnimal,
                            tempoGestacao, jaulaMam);

                    System.out.println("Animal " + mamifero.nome + " cadastrado!");
                    valida = 1;
                    break;

                case "R":
                    System.out.println("Informe o tipo de Habitat: ");
                    String tipoHabitat = sc.next();
                    System.out.println("Informe o ID da Jaula: ");
                    int idJaulaRep = sc.nextInt();
                    Jaula jaulaRep = Jaula.getJaulaById(idJaulaRep);
                    Repteis repteis = new Repteis(Repteis.repteis.size() + 1, nomeAnimal, especieAnimal, tipoHabitat,
                            jaulaRep);

                    System.out.println("Animal " + repteis.nome + " cadastrado!");
                    valida = 1;
                    break;

                case "A":
                    System.out.println("Informe o tipo de Plumagem: ");
                    String tipoPlumagem = sc.next();
                    System.out.println("Informe o ID da Jaula: ");
                    int idJaulaAve = sc.nextInt();
                    Jaula jaulaAve = Jaula.getJaulaById(idJaulaAve);

                    Aves aves = new Aves(Aves.aves.size() + 1, nomeAnimal, especieAnimal, tipoPlumagem, jaulaAve);

                    System.out.println("Animal " + aves.nome + " cadastrado!");
                    valida = 1;
                    break;

                default:
                    System.out.println("Tipo de animal inválido! Tente novamente: ");
                    valida = 0;
                    break;
            }
        } while (valida == 0);
    }

    public static void CadastrarAlimentacao(Scanner sc) {
        System.out.println("==== Cadastro de Alimentação ====");
        System.out.println("Data da Alimentação: ");
        String dataAlimentacao = sc.next();
        System.out.println("Descrição da Alimentação: ");
        String descricaoAlimentacao = sc.next();
        System.out.println("Informe o ID do animal que será alimentado: ");
        int idAnimal = sc.nextInt();
        Animal animalAlimentado = Animal.getAnimalById(idAnimal);

        try {
            Alimentacao alimentacao = new Alimentacao(Alimentacao.alimentacoes.size() + 1, dataAlimentacao,
                    descricaoAlimentacao, animalAlimentado);
            System.out.println("Alimentação de " + alimentacao.data + " para o animal " + animalAlimentado.especie
                    + " cadastrada!");

        } catch (Exception e) {
            System.out.println("Animal não encontrado!");
        }
    }

    public static void ListarJaulas() {
        System.out.println("==== Lista de Jaulas ====");
        for (Jaula jaula : Jaula.jaulas) {
            System.out.println(jaula.toString());
        }
    }

    public static void ListarAnimais() {
        System.out.println("==== Lista de Animais ====");
        System.out.println("\nMAMÍFEROS");
        for (Mamiferos mamifero : Mamiferos.mamiferos) {
            System.out.println(mamifero.toString());
        }
        System.out.println("\nRÉPTEIS");
        for (Repteis repteis : Repteis.repteis) {
            System.out.println(repteis.toString());
        }
        System.out.println("\nAVES");
        for (Aves aves : Aves.aves) {
            System.out.println(aves.toString());
        }
    }

    public static void ListarAlimentacoes() {
        System.out.println("==== Lista de Alimentações ====");
        for (Alimentacao alimentacao : Alimentacao.alimentacoes) {
            System.out.println(alimentacao.toString());
        }
    }
}
