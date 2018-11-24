package nl.cge.budget.cmd;

import nl.cge.budget.transaktie.boudary.TransaktieBoundary;
import nl.cge.budget.transaktie.entity.Transaktie;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;
import static java.util.stream.Collectors.toMap;

public class FindCommand implements Command {

    @Override
    public String commandName() {
        return "find";
    }

    @Override
    public void execute(String command) {
        Map<String, String> arguments = Arrays.stream(command.split("[-+]"))
                .skip(1)
                .filter(a -> a.length() > 1) // argumenten zonder waarden wegfilteren
                .collect(toMap(a -> a.substring(0, 1), a -> a.substring(1).trim()));

        arguments.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        List<Transaktie> transakties = new TransaktieBoundary().find(arguments);
        transakties.forEach(out::println);
        BigDecimal total = transakties.stream().map(t -> t.bedrag).reduce(BigDecimal.ZERO, BigDecimal::add);
        out.println("Toaal: " + total);
    }
}
