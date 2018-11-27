package nl.cge.budget.querytag.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class QueryTag implements Serializable {

    private Integer id;

    private Map<String, String> query = new HashMap<>();

    public String getTag() {
        return query.get("T");
    }

    public String getQuery() {
        return query.entrySet().stream()
                .filter(entry -> !entry.getKey().contains("T"))
                .map(entry -> "-" + entry.getKey() + entry.getValue())
                .reduce((a, b) -> a + " " + b)
                .orElse("");
    }

}
