package br.fag.reader;

import br.fag.acumulado.Acumulado;
import br.fag.arrecadacao.Arrecadacao;
import br.fag.bolas.Bolas;
import br.fag.cidades.Cidades;
import br.fag.concurso.Concurso;
import br.fag.datas.Datas;
import br.fag.estimativa.Estimativa;
import br.fag.ganhadores.Ganhadores;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public List<Concurso> lerPlanilha(String caminhoDaPlanilha) throws IOException {
     List<Concurso> concursos = new ArrayList<>();

     FileInputStream arquivo = new FileInputStream(caminhoDaPlanilha);
     Workbook workbook = new XSSFWorkbook(arquivo);
     Sheet sheet = workbook.getSheetAt(0);

     for (Row row: sheet) {
         if(row.getRowNum() == 0){
             continue;
         }

         Concurso concurso = criarConcursoAPartirDalinha(row);
         concursos.add(concurso);
     }
     arquivo.close();
     return concursos;
    }
    private Concurso criarConcursoAPartirDalinha(Row row){
        Concurso concurso = new Concurso();
        Datas datas = new Datas();
        concurso.setId((int) row.getCell(0).getNumericCellValue());
        datas.setDatas(row.getCell(1).getStringCellValue());
        concurso.setDataSorteio(datas);
        Bolas bolas = new Bolas();

        bolas.setBola1((int) row.getCell(2).getNumericCellValue());
        bolas.setBola2((int) row.getCell(3).getNumericCellValue());
        bolas.setBola3((int) row.getCell(4).getNumericCellValue());
        bolas.setBola4((int) row.getCell(5).getNumericCellValue());
        bolas.setBola5((int) row.getCell(6).getNumericCellValue());
        bolas.setBola6((int) row.getCell(7).getNumericCellValue());

        Ganhadores ganhadores = new Ganhadores();

        ganhadores.setGanhadores6((int) row.getCell(8).getNumericCellValue());
        ganhadores.setGanhadores5((int) row.getCell(12).getNumericCellValue());
        ganhadores.setGanhadores4((int) row.getCell(14).getNumericCellValue());

        ganhadores.setRateio6((int) row.getCell(10).getNumericCellValue());
        ganhadores.setRateio5((int) row.getCell(13).getNumericCellValue());
        ganhadores.setRateio4((int) row.getCell(15).getNumericCellValue());

        Cidades cidades = new Cidades();

        cidades.setCidades(row.getCell(11).getStringCellValue());

        Acumulado acumulados = new Acumulado();

        acumulados.setAcomulado((float) row.getCell(16).getNumericCellValue());
        acumulados.setAcomuladoVirada((float) row.getCell(19).getNumericCellValue());

        Estimativa estimativas = new Estimativa();

        estimativas.setEstimativa((float) row.getCell(18).getNumericCellValue());

        Arrecadacao arrecadacaos = new Arrecadacao();

        arrecadacaos.setTotal((float) row.getCell(17).getNumericCellValue());
        return concurso;
    }
}
