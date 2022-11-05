package baseball.controller;

import baseball.service.ComputerBaseballService;
import java.util.List;

public class BaseballController {
    private ComputerBaseballService computerBaseballService = ComputerBaseballService.getInstance();

    // start: Singleton
    private BaseballController() {
    }

    private static class InnerBaseballController {
        private static final BaseballController instance = new BaseballController();
    }

    public static BaseballController getInstance() {
        return InnerBaseballController.instance;
    }
    // end: Singleton


    public void createNewBaseballGameNumberList() {
        computerBaseballService.createNewBaseballGameNumberList();
    }
    public List<Integer> getComputerBaseballGameNumberList() {
        return computerBaseballService.getComputerBaseballGameNumberList();
    }
}
