package Services.reader.megasena;

import Models.concurso.Concurso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MegaSena extends Concurso {
    private Set<Integer> Resultado = new HashSet<>();
    public String ultimoResultado(List<Concurso> concursos) {
        long ultimoPremio = 0;
        Date dataMaisRecente = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Concurso concurso : concursos) {
            String dataSorteioStr = concurso.getDataSorteio().getDatas();
            try {
                Date dataSorteio = dateFormat.parse(dataSorteioStr);
                if (dataMaisRecente == null || dataSorteio.after(dataMaisRecente)) {
                    dataMaisRecente = dataSorteio;
                    ultimoPremio = (long) concurso.getGanhadores().getRateio6();
                    if (ultimoPremio == 0) {
                        ultimoPremio = (long) concurso.getAcumulados().getAcomulado();
                    }
                }
            } catch (ParseException e) {
                System.out.println("Algo deu errado");
            }
        }
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatoMoeda.format(ultimoPremio);
    }

    public void PrimeiroOutPut() {
        System.out.println("Vamos jogar na Mega-Sena");
    }

    private List<Integer> criarMegaSena() {
        List<Integer> numeros = new ArrayList<>();
        Random random = new Random();

        while (numeros.size() < 6) {
            int numero = random.nextInt(60) + 1;
            if (!numeros.contains(numero)) {
                numeros.add(numero);
            }
        }
        return numeros;
    }
    public void sortearDezenasAleatorias(List<Concurso> concursos) {
        List<Integer> dezenasSorteadas = criarMegaSena();
        System.out.println("Dezenas sorteadas aleatoriamente: " + dezenasSorteadas);
        verificarDezenas(concursos, dezenasSorteadas);
    }


    public void verificarDezenas(List<Concurso> concursos, List<Integer> dezenasEscolhidas) {
        boolean dezenasEncontradas = false;

        for (Concurso concurso : concursos) {
            List<Integer> dezenasSorteadas = new ArrayList<>();
            dezenasSorteadas.add(concurso.getBolas().getBola1());
            dezenasSorteadas.add(concurso.getBolas().getBola2());
            dezenasSorteadas.add(concurso.getBolas().getBola3());
            dezenasSorteadas.add(concurso.getBolas().getBola4());
            dezenasSorteadas.add(concurso.getBolas().getBola5());
            dezenasSorteadas.add(concurso.getBolas().getBola6());

            if (new HashSet<>(dezenasSorteadas).containsAll(dezenasEscolhidas)) {
                System.out.println("As dezenas foram sorteadas no concurso #" + concurso.getId());
                System.out.println("Data do sorteio: " + concurso.getDataSorteio().getDatas());
                dezenasEncontradas = true;
            }
        }

        if (!dezenasEncontradas) {
            System.out.println("As dezenas não foram sorteadas em nenhum concurso");
        }
    }

    public int verificarAcertos(List<Integer> numerosEscolhidos) {
        int acertos = 0;

        for (int numero : numerosEscolhidos) {
            if (Resultado.contains(numero)) {
                acertos++;
            }
        }
        return acertos;
    }
}
