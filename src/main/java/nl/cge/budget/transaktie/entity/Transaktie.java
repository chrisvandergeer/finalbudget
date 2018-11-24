package nl.cge.budget.transaktie.entity;

import java.math.BigDecimal;

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getDatum()).append(" ");
//        builder.append(transaktiedag).append("-").append(transaktiemaand).append("-").append(transaktiejaar).append(" ");
        builder.append(String.format("%-50.50s", (rekeningTegenpartij + " " + naamTegenpartij).trim()));
        builder.append(String.format("%8s", bedrag));
        builder.append(String.format(" %100.100s", omschrijving));
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
}
