package nl.cge.budget.transaktie.control.search.predicates;

import nl.cge.budget.transaktie.entity.Transaktie;

import java.util.function.Predicate;

public class TagFilter implements Predicate<Transaktie> {

    private String tag;

    public TagFilter(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean test(Transaktie transaktie) {
        if ("NOTAG".equals(tag.toUpperCase())) {
            return transaktie.getTags().isEmpty();
        }
        return transaktie.containsTag(tag);
    }
}
