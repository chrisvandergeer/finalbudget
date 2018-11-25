package nl.cge.budget.cli;

public class ExitCommand implements Command {

    @Override
    public String commandName() {
        return "exit";
    }

    @Override
    public void execute(String command) {
        System.out.println("Bye");
        System.exit(0);
    }
}
