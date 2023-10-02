package br.fag.megasena;

import br.fag.calculos.Calculo;
import br.fag.concurso.Concurso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MegaSena extends Concurso {
    private int resultado;

    public void calcularResultado(){
        List<Concurso> concursos = new ArrayList<>();
        Calculo calculo = new Calculo();
        Map<Integer, Integer> frequenciaNumeros = calculo.calcularFrequenciaNumeros(concursos);
        calculo.calcularFrequenciaNumeros(concursos);
    }
}
