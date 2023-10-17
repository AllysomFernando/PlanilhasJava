package br.fag.Controllers.reader;


import Models.cidades.Cidades;

import br.fag.Models.acumulado.Acumulado;
import br.fag.Models.arrecadacao.Arrecadacao;
import br.fag.Models.bolas.Bolas;
import br.fag.Models.concurso.Concurso;
import br.fag.Models.datas.Datas;
import br.fag.Models.estimativa.Estimativa;
import br.fag.Models.ganhadores.Ganhadores;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
        concurso.setId((int) row.getCell(0).getNumericCellValue());
        Datas datas = new Datas();
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
        ganhadores.setGanhadores5((int) row.getCell(11).getNumericCellValue());
        ganhadores.setGanhadores4((int) row.getCell(13).getNumericCellValue());


        ganhadores.setRateio6(Long.parseLong(row.getCell(10).getStringCellValue().replaceAll("[^\\d]", "")));
        ganhadores.setRateio5(Long.parseLong(row.getCell(12).getStringCellValue().replaceAll("[^\\d]", "")));
        ganhadores.setRateio4(Long.parseLong(row.getCell(14).getStringCellValue().replaceAll("[^\\d]", "")));

        Cidades cidades = new Cidades();

        cidades.setCidades(row.getCell(9).getStringCellValue());

        Acumulado acumulados = new Acumulado();
        acumulados.setAcomulado(Long.parseLong(row.getCell(15).getStringCellValue().replaceAll("[^\\d]", "")));
        acumulados.setAcomuladoVirada(Long.parseLong(row.getCell(18).getStringCellValue().replaceAll("[^\\d]", "")));

        Estimativa estimativas = new Estimativa();

        estimativas.setEstimativa((int) Long.parseLong(row.getCell(17).getStringCellValue().replaceAll("[^\\d]", "")));
        Arrecadacao arrecadacaos = new Arrecadacao();

        arrecadacaos.setTotal(Long.parseLong(row.getCell(16).getStringCellValue().replaceAll("[^\\d]", "")));


        concurso.setBolas(bolas);
        concurso.setGanhadores(ganhadores);
        concurso.getGanhadores().setCidades(cidades);
        concurso.setAcumulados(acumulados);
        concurso.setEstimativas(estimativas);
        concurso.setArrecadacaos(arrecadacaos);
        return concurso;
    }



}
