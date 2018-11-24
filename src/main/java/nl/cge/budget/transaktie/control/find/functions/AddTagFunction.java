package nl.cge.budget.transaktie.control.find.functions;

import nl.cge.budget.transaktie.entity.Transaktie;

import java.util.function.Function;

public class AddTagFunction implements Function<Transaktie, Transaktie> {

    private String tag;

    public AddTagFunction(String tag) {
        this.tag = tag;
    }

    @Override
    public Transaktie apply(Transaktie transaktie) {
        if (tag.trim().length() > 0) {
            transaktie.addTag(tag);
        }
        return transaktie;
    }
}
