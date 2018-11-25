package nl.cge.budget.transaktie.boundary;

import nl.cge.budget.transaktie.control.search.FindTransaktieController;
import nl.cge.budget.transaktie.control.importeer.ImporteerController;
import nl.cge.budget.transaktie.entity.Transaktie;

import java.util.List;
import java.util.Map;

public class TransaktieBoundary {

    public int importeer() {
        return new ImporteerController().importeer();
    }

    public List<Transaktie> find(Map<String, String> arguments) {
        return new FindTransaktieController().find(arguments);
    }
}
