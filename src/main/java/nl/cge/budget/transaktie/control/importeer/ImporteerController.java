package nl.cge.budget.transaktie.control.importeer;

import nl.cge.budget.transaktie.entity.Transaktie;
import nl.cge.budget.transaktie.entity.TransaktieDao;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ImporteerController {

    public int importeer() {
        Path path = Paths.get("src/test/resources/transakties.csv");
        List<Transaktie> transakties = new RabobankTransaktieParser().parse(path);
        TransaktieDao.getInstance().insert(transakties);
        return transakties.size();
    }

}
