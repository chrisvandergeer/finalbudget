package nl.cge.budget.transaktie.control.find;

import nl.cge.budget.transaktie.entity.Transaktie;
import nl.cge.budget.transaktie.entity.TransaktieDao;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class FindTransaktieController {

    public List<Transaktie> find(Map<String, String> arguments) {
        Stream<Predicate<Transaktie>> transaktieFilters = new TransaktieFilterFactory().create(arguments);

        List<Transaktie> transakties = TransaktieDao.getInstance().findAll();
        return transakties.stream()
                .filter(transaktieFilters.reduce(Predicate::and).orElse(t -> true))
                .sorted(comparing(Transaktie::getTransaktiejaar)
                        .thenComparing(Transaktie::getTransaktiemaand)
                        .thenComparing(Transaktie::getTransaktiedag))
                .collect(Collectors.toList());
    }


}
