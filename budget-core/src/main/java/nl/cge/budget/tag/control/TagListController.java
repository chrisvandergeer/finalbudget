package nl.cge.budget.tag.control;

import nl.cge.budget.tag.entity.Tag;
import nl.cge.budget.tag.entity.TagDao;

import javax.inject.Inject;
import java.util.List;

public class TagListController {

    @Inject
    private TagDao tagDao;

    public List<Tag> findAll() {
        return tagDao.findAll();
    }

}
