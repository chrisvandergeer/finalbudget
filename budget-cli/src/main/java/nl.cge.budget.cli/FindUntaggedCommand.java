package nl.cge.budget.cli;

import nl.cge.budget.transaktie.boundary.TransaktieBoundary;

import javax.inject.Inject;

public class FindUntaggedCommand implements Command {

    @Inject
    private TransaktieBoundary transaktieBoundary;

    @Override
    public String commandName() {
        return "findUntagged";
    }

    @Override
    public void execute(String command) {
        transaktieBoundary.findUntagged()
                .forEach(tr -> System.out.println(tr));
    }
}
