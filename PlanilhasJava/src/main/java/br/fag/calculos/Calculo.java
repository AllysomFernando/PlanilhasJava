package br.fag.calculos;

import br.fag.bolas.Bolas;
import br.fag.concurso.Concurso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculo {
    public Map<Integer, Integer> calcularFrequenciaNumeros(List<Concurso>concursos) {
        Map<Integer, Integer> frequenciaNumeros = new HashMap<>();

        for(Concurso concurso : concursos) {
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

}
