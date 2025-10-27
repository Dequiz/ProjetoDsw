
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fila fila = new Fila(50);
        int opcao;

        do {
            System.out.println("1 - Solicitar Senha (Normal)");
            System.out.println("2 - Solicitar Senha (Prioridade)");
            System.out.println("3 - Listar as senhas");
            System.out.println("4 - Espiar");
            System.out.println("5 - Chamar próxima pessoa");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            opcao = sc.nextInt();
             sc.nextLine();
            switch (opcao) {
                case 1: {
                   System.out.println("Digite o nome: ");
                    String nome = sc.nextLine();
                    Pessoa p = new Pessoa(nome, false);
                    fila.enfileirar(p);
                    System.out.println("Senha normal adicionada: " + p);
                    break;
                }
                case 2: {
                    System.out.println("Digite o nome: ");
                    String nome = sc.nextLine();
                    Pessoa p = new Pessoa(nome, true);
                    fila.enfileirar(p);
                    System.out.println("Senha prioritária adicionada: " + p);
                    break;
                }
                case 3: {
                    System.out.println("Fila atual: " + fila);
                    break;
                }
                case 4: {
                    Pessoa frente = fila.verFrente();
                    if (frente == null) {
                        System.out.println("Fila está vazia.");
                    } else {
                        System.out.println("Próximo a ser chamado: " + frente);
                    }
                    break;
                }
                case 5: {
                    Pessoa chamado = fila.chamarFila();
                    if (chamado != null) {
                        System.out.println("Chamando: " + chamado);
                    }
                    break;
                }
                case 0: {
                    System.out.println("Saindo");
                    break;
                }
                default:
                    System.out.println("Opção invalida");
            }
        } while (opcao != 0);
    }
}
