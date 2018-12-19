package nl.cge.budget.tag.boundary;

import nl.cge.budget.tag.control.DeleteTagController;
import nl.cge.budget.tag.control.FindTagQueriesController;
import nl.cge.budget.tag.control.FindTagsController;
import nl.cge.budget.tag.entity.Tag;

import javax.inject.Inject;
import java.util.List;

public class TagBoundary {

    @Inject
    private FindTagQueriesController findTagQueriesController;

    @Inject
    private DeleteTagController deleteTagController;

    @Inject
    private FindTagsController findTagsController;

    public List<String> findAllTags() {
        return findTagsController.findAllTags();
    }

    public List<Tag> findAllTagQueries() {
        return findTagQueriesController.findAll();
    }

    public Tag deleteTag(Integer tagId) {
        return deleteTagController.deleteTag(tagId);
    }
}
