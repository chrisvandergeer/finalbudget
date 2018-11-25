package nl.cge.budget.cli;


import nl.cge.budget.transaktie.boundary.TransaktieBoundary;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Optional;
import java.util.Scanner;

public class BudgetCommandline {

    @Inject TransaktieBoundary transaktieBoundary;

    @Any
    @Inject
    private Instance<Command> commands;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            Optional<Command> optionalCommand = commands.stream()
                    .filter(c -> c.isMatch(input))
                    .findAny();
            if (optionalCommand.isPresent()) {
                optionalCommand.get().execute(input);
            } else {
                System.out.println("unknown command");
            }
        }
    }

    @PostConstruct
    public void importeer() {
        transaktieBoundary.importeer();
    }

}
