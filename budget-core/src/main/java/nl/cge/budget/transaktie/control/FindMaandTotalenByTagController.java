package nl.cge.budget.transaktie.control;

import nl.cge.budget.transaktie.entity.Transaktie;
import nl.cge.budget.transaktie.entity.TransaktieDao;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.String.*;
import static java.math.BigDecimal.ZERO;
import static java.util.stream.Collectors.*;

public class FindMaandTotalenByTagController {

    @Inject
    private TransaktieDao transaktieDao;

    public Map<String, BigDecimal> find(String tagName) {
        Map<String, BigDecimal> maandTotalen = transaktieDao.findAll().stream()
                .filter(transaktie -> transaktie.getTags().contains(tagName))
                .collect(groupingBy(tr -> format("%s-%02d", tr.getTransaktiejaar(), tr.getTransaktiemaand()),
                        mapping(Transaktie::getBedrag, reducing(ZERO, BigDecimal::add))));
        return new TreeMap<>(maandTotalen);
    }
}
