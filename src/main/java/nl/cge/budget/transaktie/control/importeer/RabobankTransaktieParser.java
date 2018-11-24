package nl.cge.budget.transaktie.control.importeer;

import nl.cge.budget.common.FinalBudgetException;
import nl.cge.budget.transaktie.entity.Transaktie;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.readAllLines;

public class RabobankTransaktieParser {

    public List<Transaktie> parse(Path transaktieFile) {
        try {
            RabobankTransaktieParser parser = new RabobankTransaktieParser();
            return readAllLines(transaktieFile).stream()
                    .skip(1)
                    .map(line -> mapTransaktie(line))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new FinalBudgetException(e);
        }
    }

    private Transaktie mapTransaktie(String line) {
        String[] fields = line.split("\",\"");
        Transaktie transaktie = new Transaktie();
        transaktie.id = fields[3];
        transaktie.rekeningnummer = fields[0].replaceAll("\"", "");
        transaktie.transaktiejaar = Integer.parseInt(fields[4].substring(0, 4));
        transaktie.transaktiemaand = Integer.parseInt(fields[4].substring(5, 7));
        transaktie.transaktiedag = Integer.parseInt(fields[4].substring(8, 10));
        transaktie.bedrag = parseBedrag(fields[6]);
        transaktie.saldoNaTransaktie = parseBedrag(fields[7]);
        transaktie.rekeningTegenpartij = fields[8];
        transaktie.naamTegenpartij = fields[9];
        transaktie.omschrijving = fields[19];
        return transaktie;
    }

    private BigDecimal parseBedrag(String field) {
        return new BigDecimal(field.replace(",", "."));
    }


}
