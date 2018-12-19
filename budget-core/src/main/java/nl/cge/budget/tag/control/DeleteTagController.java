package nl.cge.budget.tag.control;

import nl.cge.budget.tag.entity.Tag;
import nl.cge.budget.tag.entity.TagDao;

import javax.inject.Inject;

public class DeleteTagController {

    @Inject
    private TagDao tagDao;

    public Tag deleteTag(Integer tagId) {
        return tagDao.delete(tagId);
    }
}
