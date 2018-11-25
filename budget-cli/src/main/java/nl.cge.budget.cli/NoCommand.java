package nl.cge.budget.cli;

public class NoCommand implements Command {

    @Override
    public String commandName() {
        return "";
    }

    @Override
    public void execute(String command) {

    }
}
