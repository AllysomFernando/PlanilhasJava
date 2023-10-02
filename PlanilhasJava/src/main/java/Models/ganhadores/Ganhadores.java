package Models.ganhadores;

import Models.cidades.Cidades;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Ganhadores extends Cidades {
    private Integer ganhadores6;
    private Integer ganhadores5;
    private Integer ganhadores4;

    private float rateio6;
    private float rateio5;
    private float rateio4;


}
