package Controllers.calculos;

import Models.bolas.Bolas;
import Models.concurso.Concurso;
import Models.ganhadores.Ganhadores;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Calculo {
    public Map<Integer, Integer> calcularFrequenciaNumeros(List<Concurso> concursos) {
        Map<Integer, Integer> frequenciaNumeros = new HashMap<>();

        for (Concurso concurso : concursos) {
            Bolas bolas = concurso.getBolas();
            int bola1 = bolas.getBola1();
            int bola2 = bolas.getBola2();
            int bola3 = bolas.getBola3();
            int bola4 = bolas.getBola4();
            int bola5 = bolas.getBola5();
            int bola6 = bolas.getBola6();
            atualizarFrequencia(frequenciaNumeros, bola1);
            atualizarFrequencia(frequenciaNumeros, bola2);
            atualizarFrequencia(frequenciaNumeros, bola3);
            atualizarFrequencia(frequenciaNumeros, bola4);
            atualizarFrequencia(frequenciaNumeros, bola5);
            atualizarFrequencia(frequenciaNumeros, bola6);
        }
        return frequenciaNumeros;
    }
    private void atualizarFrequencia(Map<Integer, Integer> frequenciaNumeros, int numero) {
        frequenciaNumeros.put(numero, frequenciaNumeros.getOrDefault(numero, 0) + 1);
    }
    public void calcularMenorEMaiorValorPago(List<Concurso> concursos, int dezenasSorteadas) {
        float menorValorPago = Float.MAX_VALUE;
        float maiorValorPago = 0.0f;

        for (Concurso concurso : concursos) {
            Ganhadores ganhadores = concurso.getGanhadores();
            float valorPago = 0.0f;

            switch (dezenasSorteadas) {
                case 4 -> valorPago = ganhadores.getRateio4();
                case 5 -> valorPago = ganhadores.getRateio5();
                case 6 -> valorPago = ganhadores.getRateio6();
                default -> System.out.println("Dezena Inválida");
            }

            if (valorPago > 0) {
                if (valorPago < menorValorPago) {
                    menorValorPago = valorPago;
                }
                if (valorPago > maiorValorPago) {
                    maiorValorPago = valorPago;
                }
            }
        }
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("Menor Valor Pago " + "da dezena: " + dezenasSorteadas+ ": " + formatoMoeda.format(menorValorPago));
        System.out.println("Maior Valor Pago " + "da dezena: " + dezenasSorteadas+ ": " + formatoMoeda.format(maiorValorPago));
    }

    public int calcularConcursosSemGanhador6(List<Concurso> concursos){
        int concursosSemGanhador6 = 0;

        for (Concurso concurso : concursos){
            Ganhadores ganhadores = concurso.getGanhadores();
            int ganhador6 = ganhadores.getGanhadores6();

            if(ganhador6 == 0){
                concursosSemGanhador6++;
            }
        }
        return concursosSemGanhador6;
    }

    public int quantidadeDeGanhador4(List<Concurso> concursos){
        int ganhador4 = 0;
        for (Concurso concurso :concursos){
            Ganhadores ganhadores = concurso.getGanhadores();
            int ganhadores4 = ganhadores.getGanhadores4();

            if(ganhadores4 > 1){
                ganhador4++;
            }
        }
        return ganhador4;
    }
    public int quantidadeDeGanhador5(List<Concurso> concursos){
        int ganhador5 = 0;
        for (Concurso concurso :concursos){
            Ganhadores ganhadores = concurso.getGanhadores();
            int ganhadores5 = ganhadores.getGanhadores5();

            if(ganhadores5 > 1){
                ganhador5++;
            }
        }
        return ganhador5;
    }

    public int quantidadeDeGanhador6(List<Concurso> concursos){
        int ganhador6 = 0;
        for (Concurso concurso :concursos){
            Ganhadores ganhadores = concurso.getGanhadores();
            int ganhadores6 = ganhadores.getGanhadores6();

            if(ganhadores6 > 1){
                ganhador6++;
            }
        }
        return ganhador6;
    }
}
