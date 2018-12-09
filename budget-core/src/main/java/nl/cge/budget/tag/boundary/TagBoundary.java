package nl.cge.budget.tag.boundary;

import nl.cge.budget.tag.control.TagListController;
import nl.cge.budget.tag.entity.Tag;

import javax.inject.Inject;
import java.util.List;

public class TagBoundary {

    @Inject
    private TagListController tagListController;

    public List<Tag> findAllTags() {
        return tagListController.findAll();
    }
}
