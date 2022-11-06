package baseball;

import custom.controller.BaseBallController;
import custom.service.BaseBallService;
import custom.table.Table;
import custom.viewer.Viewer;

public class Application {

    private static Viewer viewer;

    public static void main(String[] args) {
        dependencyInjection();
        viewer.run();
    }

    private static void dependencyInjection() {
        Table table = Table.init("000");
        BaseBallService baseBallService = new BaseBallService(table);
        BaseBallController baseBallController = new BaseBallController(baseBallService);
        viewer = new Viewer(baseBallController);
    }
}
