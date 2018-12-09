package nl.cge.budget.cli;

import nl.cge.budget.tag.entity.TagDao;

import javax.inject.Inject;

public class ExitCommand implements Command {

    @Inject
    private TagDao tagDao;

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
