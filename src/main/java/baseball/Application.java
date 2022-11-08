package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GenerateRandNumber generateNumber = new GenerateRandNumber();
        List<Integer> correctRandNumber = generateNumber.arrayNum();

        boolean reGameStatus = true;
        while (reGameStatus) {
            boolean gameStatus = true;
            while (gameStatus) {

                GetUserNumber userInput = new GetUserNumber();
                String userRandNumber = userInput.inputUserNumber();

                CalcCount countResult = new CalcCount();
                List<Integer> countStrBallList= countResult.CountStrike(userRandNumber, correctRandNumber);

                PrintOutput printResult = new PrintOutput();
                printResult.print(countStrBallList);

                IsRerun checkStatus = new IsRerun();
                boolean isTrue = checkStatus.isFalse(gameStatus, countStrBallList);
                gameStatus = isTrue;

            }
            GameAgain gameAgain = new GameAgain();
            boolean reGame = gameAgain.isAgain();
            reGameStatus = reGame;
        }
    }
}