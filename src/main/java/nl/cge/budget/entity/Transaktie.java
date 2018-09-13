package nl.cge.budget.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Transaktie {

    public String id;
    public String rekeningnummer;
    public String transaktiejaar;
    public String transaktiemaand;
    public String transaktiedag;
    public BigDecimal bedrag;
    public BigDecimal saldoNaTransaktie;
    public String rekeningTegenpartij;
    public String naamTegenpartij;
    public String omschrijving;

    @Override
    public String toString() {
        return "Transaktie{" +
                "id='" + id + '\'' +
                ", rekeningnummer='" + rekeningnummer + '\'' +
                ", transaktiejaar='" + transaktiejaar + '\'' +
                ", transaktiemaand='" + transaktiemaand + '\'' +
                ", transaktiedag='" + transaktiedag + '\'' +
                ", bedrag=" + bedrag +
                ", saldoNaTransaktie=" + saldoNaTransaktie +
                ", rekeningTegenpartij='" + rekeningTegenpartij + '\'' +
                ", naamTegenpartij='" + naamTegenpartij + '\'' +
                ", omschrijving='" + omschrijving + '\'' +
                '}';
    }


    /*
     "IBAN/BBAN",
    "Munt",
    "BIC",
    "Volgnr",
    "Datum",
    "Rentedatum",
    "Bedrag",
    "Saldo na trn",
    "Tegenrekening IBAN/BBAN",
    "Naam tegenpartij",
    "Naam uiteindelijke partij",
    "Naam initi�rende partij",
    "BIC tegenpartij",
    "Code",
    "Batch ID",
    "Transactiereferentie",
    "Machtigingskenmerk",
    "Incassant ID",
    "Betalingskenmerk",
    "Omschrijving-1",
    "Omschrijving-2",
    "Omschrijving-3",
    "Reden retour",
    "Oorspr bedrag",
    "Oorspr munt",
    "Koers"
     */
}
