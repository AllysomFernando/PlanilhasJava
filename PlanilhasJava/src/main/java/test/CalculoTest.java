package test;

import br.fag.Controllers.calculos.Calculo;
import br.fag.Models.concurso.Concurso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CalculoTest {
    @Test
    public void testCalcularFrequenciaNumeros() {
        Calculo calculo = new Calculo();

        // Crie uma lista de concursos de teste
        List<Concurso> concursos = createTestConcursos();

        Map<Integer, Integer> frequenciaNumeros = calculo.calcularFrequenciaNumeros(concursos);

        assertEquals(2, frequenciaNumeros.get(1));
        assertEquals(3, frequenciaNumeros.get(2));
    }

    private List<Concurso> createTestConcursos() {
        List<Concurso> concursos = new ArrayList<>();

        Concurso concurso1 = new Concurso();
        Concurso concurso2 = new Concurso();
        concursos.add(concurso1);
        concursos.add(concurso2);

        return concursos;
    }
}
