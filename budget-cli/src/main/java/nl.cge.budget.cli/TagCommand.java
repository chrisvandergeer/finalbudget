package nl.cge.budget.cli;

import nl.cge.budget.tag.boundary.TagBoundary;
import nl.cge.budget.tag.entity.TagDao;

import javax.inject.Inject;

public class TagCommand implements Command {

    @Inject
    private TagBoundary tagBoundary;

    @Inject
    private TagDao tagDao;

    @Override
    public String commandName() {
        return "tag";
    }

    @Override
    public void execute(String command) {
        tagBoundary.findAllTags().forEach(tag -> {
            System.out.println(tag.getId() + ". [" + tag.getTag() + "]" + tag.getQuery());
        });
    }
}
