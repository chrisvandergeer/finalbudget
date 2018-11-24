package nl.cge.budget.cmd;

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
