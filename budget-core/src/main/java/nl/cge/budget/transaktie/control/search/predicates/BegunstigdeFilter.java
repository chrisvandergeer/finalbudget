package nl.cge.budget.transaktie.control.search.predicates;

import nl.cge.budget.transaktie.entity.Transaktie;

import java.util.function.Predicate;

public class BegunstigdeFilter implements Predicate<Transaktie> {

    private String begunstigde;

    public BegunstigdeFilter(String begunstigde) {
            this.begunstigde = begunstigde.toUpperCase();
    }

    @Override
    public boolean test(Transaktie transaktie) {
        return ("" + transaktie.naamTegenpartij + transaktie.rekeningTegenpartij).toUpperCase().contains(begunstigde);
    }
}
