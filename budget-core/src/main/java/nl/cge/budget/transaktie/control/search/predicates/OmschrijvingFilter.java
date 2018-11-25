package nl.cge.budget.transaktie.control.search.predicates;

import nl.cge.budget.transaktie.entity.Transaktie;

import java.util.function.Predicate;

public class OmschrijvingFilter implements Predicate<Transaktie> {

    private String omschijving;

    public OmschrijvingFilter(String omschijving) {
        this.omschijving = omschijving.toUpperCase();
    }

    @Override
    public boolean test(Transaktie transaktie) {
        return ("" + transaktie.omschrijving).toUpperCase().contains(omschijving);
    }
}
