package br.fag.Models.arrecadacao;

import br.fag.Models.concurso.Concurso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Arrecadacao {
    private Concurso concurso;
    private float total;
}
