package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGameController {
    private BaseBallGameModel baseBallGameModel;
    private UserNumber userNumber;

    public BaseBallGameController() {
        baseBallGameModel = new BaseBallGameModel();
        userNumber = new UserNumber();
    }

    public void startGame() {
        baseBallGameModel.createRandomNumber();

        while (!baseBallGameModel.isFinish()) {
            System.out.print("숫자를 입력해주세요 : ");

            String userInput = receiveUserNumber();
            userNumber.setUserNumbers(userInput);

            printResult();
        }
    }

    private void printResult() {
        List<Integer> userNumbers = userNumber.getUserNumbers();
        int strike = baseBallGameModel.strikeCount(userNumbers);
        int ball = baseBallGameModel.ballCount(userNumbers);

        BaseBallGameView.printResult(ball, strike);
    }

    private String receiveUserNumber() {
        String userInput = Console.readLine();

        return userInput;
    }
}
