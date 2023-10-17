package br.fag.Models.estimativa;


import br.fag.Models.concurso.Concurso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estimativa  {
    private Concurso concurso;
    private Integer estimativa;
}
