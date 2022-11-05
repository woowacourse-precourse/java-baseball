package baseball.controller;

import baseball.service.ComputerBaseballService;
import java.util.List;

public class BaseBallController {
    private ComputerBaseballService computerBaseballService = ComputerBaseballService.getInstance();

    // start: Singleton
    private BaseBallController() {
    }

    private static class InnerBaseBallController {
        private static final BaseBallController instance = new BaseBallController();
    }

    public static BaseBallController getInstance() {
        return InnerBaseBallController.instance;
    }
    // end: Singleton


    public void createNewBaseballGameNumberList() {
        computerBaseballService.createNewBaseballGameNumberList();
    }
    public List<Integer> getComputerBaseballGameNumberList() {
        return computerBaseballService.getComputerBaseballGameNumberList();
    }
}
