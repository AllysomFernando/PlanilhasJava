package Models.acumulado;

import Models.concurso.Concurso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Acumulado extends Concurso {
    private float acomulado;
    private float acomuladoVirada;
}

