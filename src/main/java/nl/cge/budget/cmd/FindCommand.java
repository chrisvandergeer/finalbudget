package nl.cge.budget.cmd;

import nl.cge.budget.transaktie.boudary.TransaktieBoundary;
import nl.cge.budget.transaktie.entity.Transaktie;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindCommand implements Command {

    @Override
    public String commandName() {
        return "find";
    }

    @Override
    public void execute(String command) {
        Map<String, String> arguments = Arrays.stream(command.split("[-+]"))
                .skip(1)
                .filter(a -> a.length() > 1)
                .collect(Collectors.toMap(a -> a.substring(0, 1), a -> a.substring(1).trim()));

        List<Transaktie> transakties = new TransaktieBoundary().find(arguments);
        transakties.forEach(t -> System.out.println(t));
        BigDecimal total = transakties.stream().map(t -> t.bedrag).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Toaal: " + total);
    }
}
