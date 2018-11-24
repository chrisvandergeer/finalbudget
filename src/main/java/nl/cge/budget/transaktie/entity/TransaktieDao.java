package nl.cge.budget.transaktie.entity;

import java.util.ArrayList;
import java.util.List;

public class TransaktieDao {

    private static List<Transaktie> transaktieList = new ArrayList<>();

    public static TransaktieDao getInstance() {
        return new TransaktieDao();
    }

    public void insert(List<Transaktie> transakties) {
        transaktieList.addAll(transakties);
    }

    public List<Transaktie> findAll() {
        return new ArrayList<>(transaktieList);
    }
}
