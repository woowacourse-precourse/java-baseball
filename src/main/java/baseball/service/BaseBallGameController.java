package baseball.service;

import baseball.model.BaseBallGameModel;
import baseball.model.UserNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGameController {
    private BaseBallGameModel baseBallGameModel;
    private UserNumber userNumber;

    public BaseBallGameController() {
        baseBallGameModel = new BaseBallGameModel();
        userNumber = new UserNumber();
    }

    public void run() {
        baseBallGameModel.initialize();

        while (!baseBallGameModel.isFinish()) {
            System.out.print("숫자를 입력해주세요 : ");

            String userInput = receiveUserNumber();
            userNumber.set(userInput);

            printResult();
        }
    }

    private void printResult() {
        List<Integer> userNumbers = userNumber.get();
        int strike = baseBallGameModel.countStrikes(userNumbers);
        int ball = baseBallGameModel.countBalls(userNumbers);

        BaseBallGameView.printResult(ball, strike);
    }

    private String receiveUserNumber() {
        String userInput = Console.readLine();

        return userInput;
    }
}
