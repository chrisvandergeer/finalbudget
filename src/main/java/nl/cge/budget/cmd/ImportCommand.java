package nl.cge.budget.cmd;

import nl.cge.budget.transaktie.boundary.TransaktieBoundary;

public class ImportCommand implements Command {

    @Override
    public String commandName() {
        return "import";
    }

    @Override
    public void execute(String command) {
        int aantal = new TransaktieBoundary().importeer();
        System.out.println(aantal + " transakties geimporteerd");
    }
}
