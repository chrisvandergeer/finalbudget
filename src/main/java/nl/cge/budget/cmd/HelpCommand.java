package nl.cge.budget.cmd;

public class HelpCommand implements Command {

    @Override
    public String commandName() {
        return "help";
    }

    @Override
    public void execute(String command) {
        System.out.println("help\ttoont deze help");
        System.out.println("exit\tsluit dhe applicatie");
    }
}
