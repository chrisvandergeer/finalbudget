package nl.cge.budget.transaktie.control.find.functions;

import nl.cge.budget.transaktie.entity.Transaktie;

import java.util.function.Function;

public class RemoveTagFunction implements Function<Transaktie, Transaktie> {

    private String tag;

    public RemoveTagFunction(String tag) {
        this.tag = tag;
    }

    @Override
    public Transaktie apply(Transaktie transaktie) {
        transaktie.removeTag(tag);
        return transaktie;
    }
}
