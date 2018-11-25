package nl.cge.budget.cli;

import nl.cge.budget.transaktie.boundary.TransaktieBoundary;

import javax.inject.Inject;

public class ImportCommand implements Command {

    @Inject
    private TransaktieBoundary transaktieBoundary;

    @Override
    public String commandName() {
        return "import";
    }

    @Override
    public void execute(String command) {
        int aantal = transaktieBoundary.importeer();
        System.out.println(aantal + " transakties geimporteerd");
    }
}
