package nl.cge.budget.transaktie.boundary;

import nl.cge.budget.transaktie.control.search.FindUntaggedTransaktiesController;
import nl.cge.budget.transaktie.control.importeer.ImporteerController;
import nl.cge.budget.transaktie.control.search.FindTransaktieController;
import nl.cge.budget.transaktie.entity.Transaktie;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class TransaktieBoundary {

    @Inject
    private ImporteerController importeerController;

    @Inject
    private FindTransaktieController findTransaktieController;

    @Inject
    private FindUntaggedTransaktiesController findUntaggedTransaktiesController;

    public int importeer() {
        return importeerController.importeer();
    }

    public List<Transaktie> find(Map<String, String> arguments) {
        return findTransaktieController.find(arguments);
    }

    public List<Transaktie> findUntagged() {
        return findUntaggedTransaktiesController.findUntaggedTransakties();
    }
}
