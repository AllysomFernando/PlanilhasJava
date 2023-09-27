package br.fag.concurso;

import br.fag.bolas.Bolas;
import br.fag.datas.Datas;
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
    private Bolas bolas;

}
