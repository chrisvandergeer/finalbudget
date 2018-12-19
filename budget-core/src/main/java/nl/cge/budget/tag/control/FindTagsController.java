package nl.cge.budget.tag.control;

import nl.cge.budget.tag.entity.TagDao;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class FindTagsController {

    @Inject
    private TagDao tagDao;

    public List<String> findAllTags() {
        return tagDao.findAllTagQueries().stream()
                .map(tag -> tag.getTag())
                .distinct()
                .collect(Collectors.toList());
    }
}
