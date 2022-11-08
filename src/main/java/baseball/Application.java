package baseball;

import java.util.List;

public class Application {
    private static PrepareGame prepareGame = new PrepareGame();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            numberBaseballGame();
        } while (prepareGame.isGameExit());
        System.out.println("게임 종료");
    }

    private static void numberBaseballGame() {
        List<Integer> computerNumber = prepareGame.setComputerNumber();
        repeatGameUntilThreeStrike(computerNumber);
    }

    private static void repeatGameUntilThreeStrike(List<Integer> computerNumber) {
        int strike = 0;

        do {
            List<Integer> userNumber = prepareGame.userNumberToList(prepareGame.setUserNumber());
            PlayGame playGame = new PlayGame(computerNumber, userNumber);
            strike = playGame.checkStrikeAndBall();
        } while (strike != 3);
    }
}
