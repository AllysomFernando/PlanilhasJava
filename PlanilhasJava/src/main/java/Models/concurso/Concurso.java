package Models.concurso;

import Models.acumulado.Acumulado;
import Models.arrecadacao.Arrecadacao;
import Models.bolas.Bolas;
import Models.datas.Datas;
import Models.estimativa.Estimativa;
import Models.ganhadores.Ganhadores;
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
