package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean gameEndFlag = false;

        while (!gameEndFlag) {
            List<String> randomNumber = AnswerGenerator.generateRandNum();
            BaseballGame baseballGame = new BaseballGame(randomNumber);
            baseballGame.playGame();

            String userInputToChooseGameRestartOrEnd = Console.readLine();
            View.raiseErrorWhenInputIsNotOneOrTwo(userInputToChooseGameRestartOrEnd);

            if (userInputToChooseGameRestartOrEnd.equals(View.GAME_END)) {
                gameEndFlag = true;
            }
        }
        View.showGameEndMassage();
    }
}
