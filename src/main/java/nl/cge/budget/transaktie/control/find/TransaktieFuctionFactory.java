package nl.cge.budget.transaktie.control.find;

import nl.cge.budget.common.FinalBudgetException;
import nl.cge.budget.transaktie.control.find.functions.AddTagFunction;
import nl.cge.budget.transaktie.control.find.functions.RemoveTagFunction;
import nl.cge.budget.transaktie.entity.Transaktie;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class TransaktieFuctionFactory {

    private static Map<String, Class<? extends Function<Transaktie, Transaktie>>> functions = new HashMap<>();
    static {
        functions.put("T", AddTagFunction.class);
        functions.put("D", RemoveTagFunction.class);
    }

    public Stream<Function<Transaktie, Transaktie>> create(Map<String, String> arguments) {
        return arguments.entrySet().stream()
                .filter((e) -> TransaktieFuctionFactory.functions.containsKey(e.getKey()))
                .map(e -> createFunction(e));
    }

    private Function<Transaktie, Transaktie> createFunction(Map.Entry<String, String> entry) {
        try {
            return functions.get(entry.getKey()).getConstructor(String.class).newInstance(entry.getValue());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new FinalBudgetException(e);
        }
    }
}
