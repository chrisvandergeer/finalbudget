package nl.cge.budget.cmd;

public class NoCommand implements Command {

    @Override
    public String commandName() {
        return "";
    }

    @Override
    public void execute(String command) {

    }
}
