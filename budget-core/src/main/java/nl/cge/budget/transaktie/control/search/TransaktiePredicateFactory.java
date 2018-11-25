package nl.cge.budget.transaktie.control.search;

import nl.cge.budget.common.FinalBudgetException;
import nl.cge.budget.transaktie.control.search.predicates.*;
import nl.cge.budget.transaktie.entity.Transaktie;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TransaktiePredicateFactory {

    private static Map<String, Class<? extends Predicate<Transaktie>>> filters = new HashMap<>();
    static {
        filters.put("m", MaandFilter.class);
        filters.put("j", JaarFilter.class);
        filters.put("b", BegunstigdeFilter.class);
        filters.put("o", OmschrijvingFilter.class);
        filters.put("t", TagFilter.class);
    }

    public Stream<Predicate<Transaktie>> create(Map<String, String> arguments) {
        return arguments.entrySet().stream()
                .filter((e) -> TransaktiePredicateFactory.filters.containsKey(e.getKey()))
                .map(e -> createFilter(e));
    }

    private Predicate<Transaktie> createFilter(Map.Entry<String, String> entry) {
        try {
            return filters.get(entry.getKey()).getConstructor(String.class).newInstance(entry.getValue());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new FinalBudgetException(e);
        }
    }
}
