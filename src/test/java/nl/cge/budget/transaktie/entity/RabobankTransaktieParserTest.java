package nl.cge.budget.transaktie.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import nl.cge.budget.transaktie.control.importeer.RabobankTransaktieParser;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class RabobankTransaktieParserTest {

    @Test
    void test() throws IOException {
        Path path = Paths.get("src/test/resources/transakties.csv");
        List<Transaktie> transakties = new RabobankTransaktieParser().parse(path);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        transakties.forEach(t -> {
            System.out.println(gson.toJson(t));
        });

    }

}