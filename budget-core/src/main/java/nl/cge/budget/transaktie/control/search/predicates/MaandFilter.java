package nl.cge.budget.transaktie.control.search.predicates;

import nl.cge.budget.transaktie.entity.Transaktie;

import java.util.function.Predicate;

public class MaandFilter implements Predicate<Transaktie> {

    private Integer maandFilter;

    public MaandFilter(String filterValue) {
        this.maandFilter = Integer.parseInt(filterValue);
    }

    @Override
    public boolean test(Transaktie transaktie) {
        return transaktie.getTransaktiemaand() == maandFilter;
    }

}
