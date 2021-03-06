package nl.cge.budget.transaktie.control.search;

import nl.cge.budget.tag.entity.Tag;
import nl.cge.budget.tag.entity.TagDao;
import nl.cge.budget.transaktie.entity.Transaktie;
import nl.cge.budget.transaktie.entity.TransaktieDao;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class FindTransaktieController {

    @Inject
    private TransaktiePredicateFactory predicateFactory;

    @Inject
    private TransaktieFuctionFactory functionFactory;

    @Inject
    private TagDao tagDao;

    public List<Transaktie> find(Map<String, String> arguments) {
        Stream<Predicate<Transaktie>> filters = predicateFactory.create(arguments);
        Stream<Function<Transaktie, Transaktie>> functions = functionFactory.create(arguments);

        if (arguments.containsKey("T")) {
            saveQuery(arguments);
        }

        return TransaktieDao.getInstance().findAll().stream()
                .filter(filters.reduce(Predicate::and).orElse(t -> true))
                .map(functions.reduce(Function::andThen).orElse(t -> t))
                .sorted(comparing(Transaktie::getTransaktiejaar)
                        .thenComparing(Transaktie::getTransaktiemaand)
                        .thenComparing(Transaktie::getTransaktiedag))
                .collect(Collectors.toList());
    }

    private void saveQuery(Map<String, String> arguments) {
        Tag tag = new Tag();
        tag.setQuery(arguments);
        tagDao.save(tag);
    }

}
