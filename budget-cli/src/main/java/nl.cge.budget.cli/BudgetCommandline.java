package nl.cge.budget.cli;



import nl.cge.budget.transaktie.boundary.TransaktieBoundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BudgetCommandline {

    public List<Command> commands = new ArrayList<>();
    {
        commands.add(new ImportCommand());
        commands.add(new FindCommand());
        commands.add(new HelpCommand());
        commands.add(new ExitCommand());
        commands.add(new NoCommand());
    }

    public static void main(String...args) {
        new BudgetCommandline().run();
    }

    private void run() {
        new TransaktieBoundary().importeer();
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

}
