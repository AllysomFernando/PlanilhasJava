package br.fag;


import br.fag.calculos.Calculo;
import br.fag.concurso.Concurso;
import br.fag.reader.Reader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        /*PC do trabalho*/
        List<Concurso> concursos = reader.lerPlanilha("D:\\Usuario\\Clones\\PlanilhasJava\\PlanilhasJava\\public\\planilha\\Mega-sena.xlsx");
        /*PC de casa*/
//      List<Concurso> concursos = reader.lerPlanilha("X:\\\\Clone\\\\PlanilhasJava\\\\PlanilhasJava\\\\public\\\\planilha\\\\Mega-sena.xlsx");


        Calculo calculo = new Calculo();
        Map<Integer, Integer> frequenciaNumeros = calculo.calcularFrequenciaNumeros(concursos);

//TODO: refatorar essa parte, ta muito feioo!
        int rateio6 = 6;
        int rateio5 = 5;
        int rateio4 = 4;
        calculo.calcularMenorEMaiorValorPago(concursos,rateio6);
        calculo.calcularMenorEMaiorValorPago(concursos,rateio5);
        calculo.calcularMenorEMaiorValorPago(concursos,rateio4);

 //TODO: fazer uma classe que lide com os output
        int concursosSemGanhador6 = calculo.calcularConcursosSemGanhador6(concursos);
        System.out.println("Quantidade de concursos sem ganhador das 6 dezenas: " + concursosSemGanhador6 + " vezes");

        int ganhadores4 = calculo.quantidadeDeGanhador4(concursos);
        System.out.println("Quantidade de ganhadores com 4 dezenas em todos os concursos: " + ganhadores4 + " vezes");

        int ganhadores5 = calculo.quantidadeDeGanhador5(concursos);
        System.out.println("Quantidade de ganhadores com 5 dezenas em todos os concursos: " + ganhadores5 + " vezes");

        int ganhadores6 = calculo.quantidadeDeGanhador6(concursos);
        System.out.println("Quantidade de ganhadores com 6 dezenas em todos os concursos: " + ganhadores6 + " vezes");
        for (Map.Entry<Integer, Integer> entry : frequenciaNumeros.entrySet()) {
            int numero = entry.getKey();
            int frequencia = entry.getValue();
            System.out.println("Número " + numero + ": " + frequencia + " vezes");
        }
    }
}

