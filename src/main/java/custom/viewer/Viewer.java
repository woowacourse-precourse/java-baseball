package custom.viewer;

import camp.nextstep.edu.missionutils.Console;
import custom.controller.BaseBallController;
import custom.dto.Response;
import custom.printer.PrintTemplate;
import custom.service.vo.GameStatus;

public class Viewer {

    private final BaseBallController baseBallController;

    public Viewer(BaseBallController baseBallController) {
        this.baseBallController = baseBallController;
    }

    public void run() {
        baseBallController.init();
        while (true) {
            System.out.println(PrintTemplate.BEGIN.getMessage());
            System.out.print(PrintTemplate.PLZ_INPUT.getMessage());
            String inputNumber = Console.readLine();
            Response answer = baseBallController.matchNumber(inputNumber);
            System.out.println(answer.getMessage());
            if (!requestRetry(answer)) {
                break;
            }
        }
    }

    private boolean requestRetry(Response answer) {
        if (answer.getGameStatus().equals(GameStatus.RETRY)) {
            System.out.println(PrintTemplate.GOOD_JOB.getMessage());
            System.out.println(PrintTemplate.IF_RETRY.getMessage());
            String retryInput = Console.readLine();
            Response retryAnswer = baseBallController.isKeepGo(retryInput);
            if (retryAnswer.getGameStatus().equals(GameStatus.EXIT)) {
                return false;
            }
            baseBallController.init();
        }
        return true;
    }
}
