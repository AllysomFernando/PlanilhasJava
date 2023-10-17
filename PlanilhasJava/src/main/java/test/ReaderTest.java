package test;

import br.fag.Controllers.reader.Reader;
import br.fag.Models.concurso.Concurso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReaderTest {
    private Reader reader;

    @BeforeEach
    public void setUp() {
        reader = new Reader();
    }

    @Test
    public void testLerPlanilha() {
        try {
            String caminhoDaPlanilha = "X:\\\\\\\\Clone\\\\\\\\PlanilhasJava\\\\\\\\PlanilhasJava\\\\\\\\public\\\\\\\\planilha\\\\\\\\Mega-sena.xlsx"; // Substitua pelo caminho real
            List<Concurso> concursos = reader.lerPlanilha(caminhoDaPlanilha);
            assertNotNull(concursos);
            assertEquals(2636, concursos.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
