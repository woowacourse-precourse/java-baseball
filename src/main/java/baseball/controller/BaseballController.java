package baseball.controller;

import baseball.service.ComputerBaseballService;
import baseball.service.OperatorService;
import baseball.service.PlayerService;
import baseball.vo.enumtype.ValidationMessage;
import java.util.List;

public class BaseballController {
    private ComputerBaseballService computerBaseballService = ComputerBaseballService.getInstance();
    private OperatorService operatorService = OperatorService.getInstance();
    private PlayerService playerService = PlayerService.getInstance();

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

    public void gameStart() {
        operatorService.printGameStartMessage();
        String inputGameNumber;
        do {
            inputGameNumber = playerService.requestInputGameNumber();
            try {
                operatorService.validateGameNumber(inputGameNumber);
            } catch (IllegalArgumentException exception) {
                System.out.println(ValidationMessage.STOP_GAME.getValue());
                break;
            }
            operatorService.operateGame(getComputerBaseballGameNumberList(), inputGameNumber);
        } while (!inputGameNumber.equals("2"));
    }
}
