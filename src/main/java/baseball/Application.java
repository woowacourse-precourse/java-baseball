package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> correctAnswer = Start.startGame();

        while (true) {
            UserInput userInput = new UserInput();
            List<Integer> slicedInput = userInput.input();

            NumberComparison comparison = new NumberComparison();
            int ballCount = comparison.checkBall(correctAnswer, slicedInput);
            int strikeCount = comparison.checkStrike(correctAnswer, slicedInput);

            GameBranch gameBranch = new GameBranch();
            int gameStatus = gameBranch.status(ballCount, strikeCount);

            if (gameStatus == -2) {
                correctAnswer = Start.reStart();
            } else if (gameStatus == -3) {
                break;
            }
        }
    }
}
