package nl.cge.budget.tag.entity;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TagDao {

    private static DB db = DBMaker.newFileDB(new File("transakties.db")).make();
    BTreeMap<Integer, Tag> table = db.getTreeMap("transakties");

    public Tag save(Tag tag) {

        if (tag.getId() == null) {
            int id = table.isEmpty() ? 1 : table.lastKey() + 1;
            tag.setId(id);
        }
        table.put(tag.getId(), tag);
        db.commit();
        return tag;
    }

    public List<Tag> findAllTagQueries() {
        return new ArrayList<>(table.values());
    }

    public Tag delete(Integer tagId) {
        Tag tag = table.get(tagId);
        table.remove(tagId);
        db.commit();
        return tag;
    }

}
