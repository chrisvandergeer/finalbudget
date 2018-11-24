package nl.cge.budget.cmd;

public class HelpCommand implements Command {

    @Override
    public String commandName() {
        return "help";
    }

    @Override
    public void execute(String command) {
        System.out.println("help\ttoont deze help");
        System.out.println("exit\tsluit dhe applicatie");
        System.out.println("import\timporteert transakties");
        System.out.println("find\tzoeken naar transakties, opties:");
        System.out.println("\t\t -b zoeken op tegenrekeningnummer / naam");
        System.out.println("\t\t -o zoeken op omschrijving");
        System.out.println("\t\t -j zoeken op jaar");
        System.out.println("\t\t -m zoeken op maand");
        System.out.println("\t\t -d zoeken op dag");
        System.out.println("\t\t -t zoeken op tag");
        System.out.println("\t\t -T toevoegen tag");
        System.out.println("\t\t -D verwijderen tag");
    }
}
