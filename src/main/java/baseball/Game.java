package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    private static final String THREE_STRIKE = "3스트라이크";
    private List<Integer> computerNumber;

    private void start(Player computer) {
        Print.startGame();
        this.computerNumber = computer.getComputerRandomNumber();
    }

    private String playGame(Player player) {
        List<Integer> score;
        List<Integer> playerNumber;

        Print.enterNumber();
        playerNumber = player.enterNumber();
        score = GameScore.getGameScore(playerNumber, this.computerNumber);

        return GameScore.getGameResult(score.get(0), score.get(1));
    }

    public void playGameAgain() {
        String result;

        Player computer = new Player();
        Player player = new Player();

        start(computer);
        result = playGame(player);
        Print.printResult(result);

        while (!checkThreeStrike(result)) {
            result = playGame(player);
            Print.printResult(result);
        }

        Print.checkGameEnd();
        playAgainOrEnd(Console.readLine());
    }

    private boolean checkThreeStrike(String result) {
        return result.equals(THREE_STRIKE);
    }

    private void playAgainOrEnd(String input) {
        InputValidation.checkGameEndChoiceNumber(input);

        if (input.equals("1")) {
            playGameAgain();
        }
    }
}
