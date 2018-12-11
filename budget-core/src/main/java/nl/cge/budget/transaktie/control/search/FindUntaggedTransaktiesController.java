package nl.cge.budget.transaktie.control.search;

import nl.cge.budget.transaktie.entity.Transaktie;
import nl.cge.budget.transaktie.entity.TransaktieDao;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class FindUntaggedTransaktiesController {

    @Inject
    private TransaktieDao transaktieDao;

    public List<Transaktie> findUntaggedTransakties() {
        return transaktieDao.findAll().stream()
                .filter(tr -> tr.getTags().isEmpty())
                .collect(Collectors.toList());
    }
}
