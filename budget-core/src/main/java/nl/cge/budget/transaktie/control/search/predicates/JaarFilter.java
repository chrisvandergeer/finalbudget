package nl.cge.budget.transaktie.control.search.predicates;

import nl.cge.budget.transaktie.entity.Transaktie;

import java.util.function.Predicate;

public class JaarFilter implements Predicate<Transaktie> {

    private Integer jaar;

    public JaarFilter(String jaar) {
            this.jaar = Integer.parseInt(jaar);
    }

    @Override
    public boolean test(Transaktie transaktie) {
        return transaktie.getTransaktiejaar().equals(jaar);
    }
}
