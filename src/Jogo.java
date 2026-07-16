import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        String nome = "Gabriel Galvão Soares";
        String tipoConta = "Conta Corrente";
        double saldoConta = 2500.00;
        double valorInformado = 0;
        String textoNome = "Nome:";
        String textoConta = "Tipo de conta:";
        String textoSaldo = "Saldo atual:";
        String nomeFormatado = String.format("%-20s", textoNome);
        String contaFormatado = String.format("%-20s", textoConta);
        String saldoFormatado = String.format("%-20s", textoSaldo);

        System.out.println("*********************************" + "\n" + "Dados iniciais do cliente:");
        System.out.println("\n");
        System.out.println(nomeFormatado + nome);
        System.out.println(contaFormatado + tipoConta);
        System.out.printf(saldoFormatado + "R$ %.2f%n", saldoConta);
        System.out.println("*********************************");

        String operacoes = """
                Operações:
                
                1 - Consultar saldo
                2 - Receber valor
                3 - Transferir valor
                4 - Sair
                
                """;
        System.out.println(operacoes);
        int resposta = leia.nextInt();

        while (resposta != 4){
            if (resposta == 1){
                System.out.printf("O saldo atual é de R$ %.2f%n", saldoConta);
            } else if (resposta == 2) {
                System.out.println("Informe o valor a receber: ");
                valorInformado = leia.nextDouble();
                saldoConta += valorInformado;
                System.out.printf("Seu saldo atual é de R$ %.2f%n", saldoConta);
            } else if (resposta == 3){
                System.out.println("Informe o valor que deseja transferir ou 0 para cancelar. ");
                valorInformado = leia.nextDouble();
                if (valorInformado <= saldoConta){
                    saldoConta -= valorInformado;
                    System.out.printf("O valor de R$ %.2f%n foi transferido, seu saldo atual é de R$ %.2f%n .", valorInformado, saldoConta);
                } else if (valorInformado == 0) {
                    break;
                } else {
                    System.out.println("Valor inválido! Tente novamente ou digite 0 para cancelar.");
                    valorInformado = leia.nextDouble();
                }
            } else {
                System.out.println("O valor informado é inválido! Tente Novamente.");
            }
            System.out.println(operacoes);
            resposta = leia.nextInt();
        }
        System.out.println("Obrigado por utilizar GalvoBank!");

    }
}
