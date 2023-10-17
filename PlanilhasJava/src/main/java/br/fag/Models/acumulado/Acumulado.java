package br.fag.Models.acumulado;


import br.fag.Models.concurso.Concurso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Acumulado {
    private Concurso concurso;
    private float acomulado;
    private float acomuladoVirada;
}

