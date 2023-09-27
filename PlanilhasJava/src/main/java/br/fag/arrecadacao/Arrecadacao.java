package br.fag.arrecadacao;

import br.fag.concurso.Concurso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Arrecadacao extends Concurso {
    public String total;
}
