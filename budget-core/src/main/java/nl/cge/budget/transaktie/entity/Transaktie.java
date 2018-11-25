package nl.cge.budget.transaktie.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Transaktie {

    public String id;
    public String rekeningnummer;
    public Integer transaktiejaar;
    public Integer transaktiemaand;
    public Integer transaktiedag;
    public BigDecimal bedrag;
    public BigDecimal saldoNaTransaktie;
    public String rekeningTegenpartij;
    public String naamTegenpartij;
    public String omschrijving;
    public Set<String> tags = new HashSet<>();

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

    public Integer getTransaktiejaar() {
        return transaktiejaar;
    }

    public Integer getTransaktiemaand() {
        return transaktiemaand;
    }

    public Integer getTransaktiedag() {
        return transaktiedag;
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
}
