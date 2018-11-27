package nl.cge.budget.querytag.entity;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class QueryTagDao {

    private static DB db = DBMaker.newFileDB(new File("transakties.db")).make();
    private static BTreeMap<Integer, QueryTag> table = db.getTreeMap("transakties");

    public QueryTag save(QueryTag queryTag) {
        if (queryTag.getId() == null) {
            int id = table.isEmpty() ? 1 : table.lastKey() + 1;
            queryTag.setId(id);
        }
        table.put(queryTag.getId(), queryTag);
        db.commit();
        return queryTag;
    }

    public List<QueryTag> findAll() {
        return table.entrySet().stream()
                .map(e -> e.getValue())
                .collect(Collectors.toList());
    }
}
