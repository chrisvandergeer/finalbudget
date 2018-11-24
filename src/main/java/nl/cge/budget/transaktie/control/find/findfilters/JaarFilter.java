package nl.cge.budget.transaktie.control.find.findfilters;

import nl.cge.budget.transaktie.entity.Transaktie;

import java.util.function.Predicate;

public class JaarFilter implements Predicate<Transaktie> {

    private Integer jaar;

    public JaarFilter(String jaar) {
            this.jaar = Integer.parseInt(jaar);
    }

    @Override
    public boolean test(Transaktie transaktie) {
        return transaktie.transaktiejaar.equals(jaar);
    }
}
