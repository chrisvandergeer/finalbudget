package nl.cge.budget.transaktie.control.importeer;

import nl.cge.budget.tag.boundary.TagBoundary;
import nl.cge.budget.transaktie.control.search.FindTransaktieController;
import nl.cge.budget.transaktie.entity.Transaktie;
import nl.cge.budget.transaktie.entity.TransaktieDao;

import javax.inject.Inject;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ImporteerController {

    @Inject
    RabobankTransaktieParser rabobankTransaktieParser;

    @Inject
    TagBoundary tagBoundary;

    @Inject
    FindTransaktieController findTransaktieController;

    public int importeer() {
        Path path = Paths.get("transakties.csv");
        List<Transaktie> transakties = rabobankTransaktieParser.parse(path);
        TransaktieDao.getInstance().insert(transakties);

        tagBoundary.findAllTags().forEach(tag -> {
                findTransaktieController.find(tag.getQueryArguments())
                        .forEach(tr -> tr.addTag(tag.getTag()));
            }
        );

        return transakties.size();
    }

}
