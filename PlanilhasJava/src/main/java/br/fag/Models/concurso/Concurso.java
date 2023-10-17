package br.fag.Models.concurso;


import br.fag.Models.acumulado.Acumulado;
import br.fag.Models.arrecadacao.Arrecadacao;
import br.fag.Models.bolas.Bolas;
import br.fag.Models.datas.Datas;
import br.fag.Models.estimativa.Estimativa;
import br.fag.Models.ganhadores.Ganhadores;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Concurso{
    private Integer id;
    private Datas dataSorteio;
    public Bolas bolas;
    private Ganhadores ganhadores;
    private Acumulado acumulados;
    private Estimativa estimativas;
    private Arrecadacao arrecadacaos;
}
