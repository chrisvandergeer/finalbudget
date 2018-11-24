package nl.cge.budget.transaktie.boudary;

import nl.cge.budget.transaktie.control.find.FindTransaktieController;
import nl.cge.budget.transaktie.control.importeer.RabobankTransaktieParser;
import nl.cge.budget.transaktie.entity.Transaktie;
import nl.cge.budget.transaktie.entity.TransaktieDao;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class TransaktieBoundary {

    public int importeer() {
        Path path = Paths.get("src/test/resources/transakties.csv");
        List<Transaktie> transakties = new RabobankTransaktieParser().parse(path);
        TransaktieDao.getInstance().insert(transakties);
        return transakties.size();
    }

    public List<Transaktie> find(Map<String, String> arguments) {
        return new FindTransaktieController().find(arguments);
    }
}
