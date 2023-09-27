package br.fag.acumulado;

import br.fag.concurso.Concurso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Acumulado extends Concurso {
    private Float acomulado;
    private Float acomuladoVirada;
}

