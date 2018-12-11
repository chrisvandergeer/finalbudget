package nl.cge.budget.tag.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Data
public class Tag implements Serializable {

    private Integer id;

    private String query = "";
    private String tag;

    public void setQuery(Map<String, String> arguments) {
        arguments.entrySet().forEach(entry -> {
            if (entry.getKey().equals("T")) {
                this.tag = entry.getValue();
            } else {
                query = query + " " + "-" + entry.getKey() + " " + entry.getValue();
            }
        });
    }

    public Map<String, String> getQueryArguments() {
        return Arrays.stream(query.split("[-+]"))
                .skip(1)
                .filter(a -> a.length() > 1) // argumenten zonder waarden wegfilteren
                .collect(toMap(a -> a.substring(0, 1), a -> a.substring(1).trim()));
    }
}
