import java.util.Scanner;
import java.util.HashMap;

public class Estacionamento {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean sistemaTicket = true;
        int numeroTicket = 1;
        double saldo = 0;
        HashMap<Integer, Double> ticketsPagos = new HashMap<>();

        while (sistemaTicket) {
            System.out.println("- TICKET ONLINE");
            System.out.println("1- Gerar Ticket");
            System.out.println("2- Ver Saldo");
            System.out.println("3- Sair");
            System.out.print("Digite a opção que deseja: ");
            int opcao = input.nextInt();

            if (opcao == 1) {
                TicketEstacionamento novoTicket = new TicketEstacionamento(numeroTicket);
                System.out.println("Ticket número " + numeroTicket);
                System.out.println("Valor do ticket: R$" + novoTicket.getValor());

                boolean painel = true;
                while (painel) {
                    System.out.println("\n- SEU TICKET");
                    System.out.println("1- Pagar");
                    System.out.println("2- Voltar");
                    System.out.print("Digite a opção que deseja: ");
                    int opcao2 = input.nextInt();

                    if (opcao2 == 1) {
                        if (!novoTicket.isPago()) {
                            novoTicket.pagar();
                            saldo += novoTicket.getValor();
                            ticketsPagos.put(numeroTicket, novoTicket.getValor());
                        } else {
                            System.out.println("Você já pagou o ticket!");
                        }
                    } else if (opcao2 == 2) {
                        if (novoTicket.isPago()) {
                            painel = false;
                        } else {
                            System.out.println("Você deve pagar o ticket antes de sair!");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
                numeroTicket++;

            } else if (opcao == 2) {
                System.out.println("- SALDO");
                for (int num : ticketsPagos.keySet()) {
                    System.out.println("Ticket " + num + " - R$" + ticketsPagos.get(num));
                }
                System.out.println("Saldo: R$" + saldo);

            } else if (opcao == 3) {
                System.out.println("Finalizando o TICKET ONLINE...");
                sistemaTicket = false;

            } else {
                System.out.println("Opção inválida.");
            }
        }

        input.close();
    }
}