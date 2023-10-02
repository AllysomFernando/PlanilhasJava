package br.fag.concurso;

import br.fag.acumulado.Acumulado;
import br.fag.arrecadacao.Arrecadacao;
import br.fag.bolas.Bolas;
import br.fag.datas.Datas;
import br.fag.estimativa.Estimativa;
import br.fag.ganhadores.Ganhadores;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Concurso extends Ganhadores {
    private Integer id;
    private Datas dataSorteio;
    public Bolas bolas;
    private Ganhadores ganhadores;
    private Acumulado acumulados;
    private Estimativa estimativas;
    private Arrecadacao arrecadacaos;
}
