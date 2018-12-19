package nl.cge.budget.cli;

import nl.cge.budget.tag.boundary.TagBoundary;

import javax.inject.Inject;

public class TagCommand implements Command {

    @Inject
    private TagBoundary tagBoundary;

    @Override
    public String commandName() {
        return "tag";
    }

    @Override
    public void execute(String command) {
        String[] splittedCommand = command.split(" ", 2);
        if (splittedCommand.length == 1) {
            executeFindAllTags();
        } else {
            String commandArguments = splittedCommand[1];
            if (commandArguments.startsWith("queries")) {
                executeFindAllTagQueries();
            }
            if (commandArguments.startsWith("delete")) {
                executeDeleteTag(commandArguments);
            }
        }
    }

    private void executeFindAllTags() {
        tagBoundary.findAllTags().forEach(t -> System.out.println("\t" + t));
    }

    private void executeFindAllTagQueries() {
        tagBoundary.findAllTagQueries().forEach(tag -> {
            System.out.println(tag.getId() + ". [" + tag.getTag() + "]" + tag.getQuery());
        });
    }

    private void executeDeleteTag(String commandArguments) {
        String[] splittedArguments = commandArguments.split(" ");
        if (splittedArguments.length == 1) {
            System.err.println("Please enter the number to delete");
        } else {
            try {
                int idx = Integer.parseInt(splittedArguments[1]);
                tagBoundary.deleteTag(idx);
            } catch (NumberFormatException e) {
                System.err.println("Please enter a valid number");
            }
        }
    }
}
