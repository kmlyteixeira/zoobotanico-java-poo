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
            System.out.println("09 - Sair");
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
                    ExcluirJaula(sc);
                    break;

                case 8:
                    ExcluirAnimal(sc);
                    break;

                case 9:
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
                    System.out.println("Informe o ID da Jaula que este animal vai habitar: ");
                    int idJaulaMam = sc.nextInt();
                    Jaula jaulaMam = Jaula.getJaulaById(idJaulaMam);
                    Mamiferos mamifero = new Mamiferos(Mamiferos.mamiferos.size() + 1, nomeAnimal, especieAnimal,tempoGestacao);

                    if (Jaula.VerificaJaulaAnimal(jaulaMam, mamifero)){
                        jaulaMam.animais.add(mamifero);
                        System.out.println("Animal " + mamifero.nome + " cadastrado!");
                    } else {
                        System.out.println("Jaula não encontrada ou não compatível com o tipo de animal!");
                    }

                    valida = 1;
                    break;

                case "R":
                    System.out.println("Informe o tipo de Habitat: ");
                    String tipoHabitat = sc.next();
                    System.out.println("Informe o ID da Jaula que este animal vai habitar: ");
                    int idJaulaRep = sc.nextInt();
                    Jaula jaulaRep = Jaula.getJaulaById(idJaulaRep);
                    Repteis repteis = new Repteis(Repteis.repteis.size() + 1, nomeAnimal, especieAnimal, tipoHabitat);

                    if (Jaula.VerificaJaulaAnimal(jaulaRep, repteis) ==  true){
                        jaulaRep.animais.add(repteis);
                        System.out.println("Animal " + repteis.nome + " cadastrado!");
                    } else {
                        System.out.println("Jaula não encontrada ou não compatível com o tipo de animal!");
                    }

                    valida = 1;
                    break;

                case "A":
                    System.out.println("Informe o tipo de Plumagem: ");
                    String tipoPlumagem = sc.next();
                    System.out.println("Informe o ID da Jaula que este animal vai habitar: ");
                    int idJaulaAve = sc.nextInt();
                    Jaula jaulaAve = Jaula.getJaulaById(idJaulaAve);

                    Aves aves = new Aves(Aves.aves.size() + 1, nomeAnimal, especieAnimal, tipoPlumagem);

                    if (Jaula.VerificaJaulaAnimal(jaulaAve, aves) ==  true){
                        jaulaAve.animais.add(aves);
                        System.out.println("Animal " + aves.nome + " cadastrado!");
                    } else {
                        System.out.println("Jaula não encontrada ou não compatível com o tipo de animal!");
                    }

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
        for (Animal animais : Animal.animais) {
            if (animais instanceof Mamiferos) {
                System.out.println(animais.toString());
            }
        }
        System.out.println("\nRÉPTEIS");
        for (Animal animais : Animal.animais) {
            if (animais instanceof Repteis) {
                System.out.println(animais.toString());
            }
        }
        for (Animal animais : Animal.animais) {
            if (animais instanceof Repteis) {
                System.out.println(animais.toString());
            }
        }
    }

    public static void ListarAlimentacoes() {
        System.out.println("==== Lista de Alimentações ====");
        for (Alimentacao alimentacao : Alimentacao.alimentacoes) {
            System.out.println(alimentacao.toString());
        }
    }

    public static void ExcluirJaula(Scanner sc){
        System.out.println("==== Excluir Jaulas ====");
        System.out.println("Informe o ID da Jaula a ser excluída: ");
        int idJaula = sc.nextInt();
        Jaula jaula = Jaula.getJaulaById(idJaula);
        
        try {
            Animal.deleteAnimalById(idJaula);
            System.out.println("Jaula "+ jaula.nome +" excluída com sucesso!");
        } catch (Exception e) {
            System.out.println("Jaula não encontrada!");
        }
    }

    public static void ExcluirAnimal(Scanner sc){
        System.out.println("==== Excluir Animais ====");
        System.out.println("Informe o ID do Animal a ser excluído: ");
        int idAnimal = sc.nextInt();
        Animal animal = Animal.getAnimalById(idAnimal);

        try {
            Animal.deleteAnimalById(idAnimal);
            System.out.println("Animal "+ animal.nome +" excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Animal não encontrado!");
        }
    }
}
