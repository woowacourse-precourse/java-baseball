package baseball;

import java.util.List;

public class Game {

    private static final int GAME_OVER_STRIKE_COUNT = 3;

    private boolean isGameRun = true;

    private final List<Integer> computerNumbers;

    private Game() {
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.getNumberList();
        this.computerNumbers = computerNumbers;
    }

    public static void startGame() {
        Game game = new Game();
        while (game.isGameRun) {
            game.getGameScore();
        }
    }

    private void getGameScore() {
        UserNumber userNumber = new UserNumber();
        List<Integer> userNumbers = userNumber.getNumberList();
        Judge.getGameScore(userNumbers, computerNumbers);
        if (Judge.countStrike(userNumbers, computerNumbers) == GAME_OVER_STRIKE_COUNT) {
            isGameRun = false;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public static String ResetGameOrQuit() {
        UserChoice userChoice = new UserChoice();
        return userChoice.getResetOrQuit();
    }
}
