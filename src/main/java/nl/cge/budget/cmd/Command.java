package nl.cge.budget.cmd;

public interface Command {

    default boolean isMatch(String command) {
        String[] splitted = command.split(" ");
        return splitted.length > 0 && splitted[0].equals(commandName());
    }

    String commandName();

    void execute(String command);
}
