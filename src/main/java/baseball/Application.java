package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean gameEndFlag = false;

        while (!gameEndFlag) {
            List<String> randomNumbers = AnswerGenerator.generateRandNum();
            BaseballGame baseballGame = new BaseballGame(randomNumbers);
            baseballGame.playGame();

            String userInputToChooseGameRestartOrEnd = Console.readLine();
            View.raiseErrorWhenInputIsNotOneOrTwo(userInputToChooseGameRestartOrEnd);

            if (userInputToChooseGameRestartOrEnd.equals(View.GAME_END)) {
                gameEndFlag = true;
            }
        }
        View.showGameEndMessage();
    }
}
