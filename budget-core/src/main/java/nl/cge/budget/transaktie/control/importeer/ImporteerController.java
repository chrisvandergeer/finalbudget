package nl.cge.budget.transaktie.control.importeer;

import nl.cge.budget.transaktie.entity.Transaktie;
import nl.cge.budget.transaktie.entity.TransaktieDao;

import javax.inject.Inject;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ImporteerController {

    @Inject RabobankTransaktieParser rabobankTransaktieParser;

    public int importeer() {
        Path path = Paths.get("transakties.csv");
        List<Transaktie> transakties = rabobankTransaktieParser.parse(path);
        TransaktieDao.getInstance().insert(transakties);
        return transakties.size();
    }

}
