package nl.cge.budget.cli;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class BudgetCommandlineStarter {

    public static void main(String... args) {
        Weld weld = new Weld();
        WeldContainer weldContainer = weld.initialize();
        BudgetCommandline application = weldContainer.select(BudgetCommandline.class).get();
        application.run();

    }
}
