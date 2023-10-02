package br.fag.views;


import Controllers.calculos.Calculo;
import Models.concurso.Concurso;
import Services.reader.megasena.MegaSena;
import Controllers.reader.Reader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        /*PC do trabalho*/
        List<Concurso> concursos = reader.lerPlanilha("D:\\Usuario\\Clones\\PlanilhasJava\\PlanilhasJava\\public\\planilha\\Mega-sena.xlsx");
        /*PC de casa*/
//      List<Concurso> concursos = reader.lerPlanilha("X:\\\\Clone\\\\PlanilhasJava\\\\PlanilhasJava\\\\public\\\\planilha\\\\Mega-sena.xlsx");

        MegaSena megaSena = new MegaSena();
        Calculo calculo = new Calculo();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Último prêmio sorteado da Mega-Sena");
            System.out.println("2. Jogar no Bixo");
            System.out.println("3. Sortear dezenas aleatórias e verificar");
            System.out.println("4. A quantidade de vezes que cada número foi sorteado");
            System.out.println("5. Quantos concursos não houve apostador que acertou as 6 dezenas");
            System.out.println("6. O menor e maior valor pago para apostas com 4 dezenas sorteadas");
            System.out.println("7. O menor e maior valor pago para apostas com 5 dezenas sorteadas");
            System.out.println("8. O menor e maior valor pago para apostas com 6 dezenas sorteadas");
            System.out.println("9. A quantidade de ganhadores com 4 dezenas em todos os concursos");
            System.out.println("10. A quantidade de ganhadores com 5 dezenas em todos os concursos");
            System.out.println("11. A quantidade de ganhadores com 6 dezenas em todos os concursos");

            System.out.print("Opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 :
                    String ultimoPremio = megaSena.ultimoResultado(concursos);
                    System.out.println("Último prêmio sorteado da Mega-Sena: R$ " + ultimoPremio);
                    break;
                case 2 :
                    megaSena.PrimeiroOutPut();
                    List<Integer> dezenasEscolhidas = new ArrayList<>();
                    System.out.println("Escolha 6 números de 1 a 60:");
                    for (int i = 0; i < 6; i++) {
                        int dezena;
                        do {
                            System.out.print("Insira a " + (i + 1) + "ª dezena: ");
                            dezena = scanner.nextInt();
                            if (dezena < 1 || dezena > 60) {
                                System.out.println("Número inválido. Escolha um número entre 1 e 60.");
                            }
                        } while (dezena < 1 || dezena > 60);

                        dezenasEscolhidas.add(dezena);
                    }
                    megaSena.verificarDezenas(concursos, dezenasEscolhidas);
                    megaSena.verificarAcertos(dezenasEscolhidas);
                    break;
                case 3 :
                    megaSena.sortearDezenasAleatorias(concursos);
                    break;
                case 4:
                    for (Map.Entry<Integer, Integer> entry : calculo.calcularFrequenciaNumeros(concursos).entrySet()) {
                        int numero = entry.getKey();
                        int frequencia = entry.getValue();
                        System.out.println("Número " + numero + ": " + frequencia + " vezes");
                    }
                    break;
                case 5 :
                    int concursosSemGanhador6 = calculo.calcularConcursosSemGanhador6(concursos);
                    System.out.println("Quantidade de concursos sem ganhador das 6 dezenas: " + concursosSemGanhador6 + " vezes");
                    break;
                case 6 :
                    int rateio4 = 4;
                    calculo.calcularMenorEMaiorValorPago(concursos,rateio4);
                    break;
                case 7 :
                    int rateio5 = 5;
                    calculo.calcularMenorEMaiorValorPago(concursos,rateio5);
                    break;
                case 8 :
                    int rateio6 = 6;
                    calculo.calcularMenorEMaiorValorPago(concursos,rateio6);
                    break;
                case 9 :
                    int ganhadores4 = calculo.quantidadeDeGanhador4(concursos);
                    System.out.println("Quantidade de ganhadores com 4 dezenas em todos os concursos: " + ganhadores4 + " vezes");
                    break;
                case 10 :
                    int ganhadores5 = calculo.quantidadeDeGanhador5(concursos);
                    System.out.println("Quantidade de ganhadores com 5 dezenas em todos os concursos: " + ganhadores5 + " vezes");
                    break;
                case 11 :
                    int ganhadores6 = calculo.quantidadeDeGanhador6(concursos);
                    System.out.println("Quantidade de ganhadores com 6 dezenas em todos os concursos: " + ganhadores6 + " vezes");

                    break;
                default:
                    System.out.println("Opção inváilida");
            }
        }while (opcao != 4);


        scanner.close();

    }
}

