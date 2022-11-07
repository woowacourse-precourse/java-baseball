package baseball.Game;

import baseball.Players.Computer;
import baseball.Players.UserChoice;
import baseball.Players.UserNumber;
import java.util.List;

public class Game {

    private static final int GAME_OVER_STRIKE_COUNT = 3;

    private boolean roundContinue = true;

    private final List<Integer> computerNumbers;

    private Game() {
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.getNumberList();
        this.computerNumbers = computerNumbers;
    }

    public static void startGame() {
        Game game = new Game();
        do {
            game.getRoundScore();
        } while (game.roundContinue);
    }

    private void getRoundScore() {
        UserNumber userNumber = new UserNumber();
        List<Integer> userNumbers = userNumber.getNumberList();
        Judge judge = new Judge(userNumbers, computerNumbers);
        judge.printRoundScore();
        if (judge.countStrike() == GAME_OVER_STRIKE_COUNT) {
            roundContinue = false;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public static String ResetGameOrQuit() {
        UserChoice userChoice = new UserChoice();
        return userChoice.getResetOrQuit();
    }
}
