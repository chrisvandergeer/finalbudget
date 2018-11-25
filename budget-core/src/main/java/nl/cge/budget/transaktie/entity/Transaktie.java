package nl.cge.budget.transaktie.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Transaktie {

    @Getter @Setter
    private String id;

    @Getter @Setter
    private String rekeningnummer;

    @Getter @Setter
    private Integer transaktiejaar;

    @Getter @Setter
    private Integer transaktiemaand;

    @Getter @Setter
    private Integer transaktiedag;

    @Getter @Setter
    private BigDecimal bedrag;

    @Getter @Setter
    private BigDecimal saldoNaTransaktie;

    @Getter @Setter
    private String rekeningTegenpartij;

    @Getter @Setter
    private String naamTegenpartij;

    @Getter @Setter
    private String omschrijving;

    private Set<String> tags = new HashSet<>();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getDatum()).append(" ");
        builder.append(String.format("%-50.50s", (rekeningTegenpartij + " " + naamTegenpartij).trim()));
        builder.append(String.format("%8s", bedrag));
        builder.append(String.format(" %70.70s", omschrijving));
        builder.append(String.format("%40s", tags.stream().sorted().reduce((t1, t2) -> t1 + "," + t2).orElse("")));
        return builder.toString();
    }

    public String getDatum() {
        return String.format("%02d-%02d-%04d", transaktiedag, transaktiemaand, transaktiejaar);
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public boolean containsTag(String tag) {
        return tags.contains(tag);
    }

    public void removeTag(String tag) {
        tags.remove(tag);
    }

    public Set<String> getTags() {
        return new HashSet<>(tags);
    }
}
