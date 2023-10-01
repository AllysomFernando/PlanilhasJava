package br.fag;

import br.fag.reader.Reader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        reader.lerPlanilha("X:\\Clone\\PlanilhasJava\\PlanilhasJava\\public\\planilha\\Mega-sena.xlsx");
    }
}
