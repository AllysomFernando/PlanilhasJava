package br.fag.Models.bolas;

import br.fag.Models.concurso.Concurso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bolas {
    private Concurso concurso;
    private Integer bola1;
    private Integer bola2;
    private Integer bola3;
    private Integer bola4;
    private Integer bola5;
    private Integer bola6;
}
