package nl.cge.budget.transaktie.control.find;

import nl.cge.budget.common.FinalBudgetException;
import nl.cge.budget.transaktie.control.find.findfilters.BegunstigdeFilter;
import nl.cge.budget.transaktie.control.find.findfilters.JaarFilter;
import nl.cge.budget.transaktie.control.find.findfilters.MaandFilter;
import nl.cge.budget.transaktie.control.find.findfilters.OmschrijvingFilter;
import nl.cge.budget.transaktie.entity.Transaktie;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TransaktieFilterFactory {

    private static Map<String, Class<? extends Predicate<Transaktie>>> filters = new HashMap<>();
    static {
        filters.put("m", MaandFilter.class);
        filters.put("j", JaarFilter.class);
        filters.put("b", BegunstigdeFilter.class);
        filters.put("o", OmschrijvingFilter.class);
    }

    public Stream<Predicate<Transaktie>> create(Map<String, String> arguments) {
        return arguments.entrySet().stream()
                .filter((e) -> TransaktieFilterFactory.filters.containsKey(e.getKey()))
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
