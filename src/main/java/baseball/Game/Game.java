package baseball.Game;

import baseball.Players.Computer;
import baseball.Players.UserChoice;
import baseball.Players.UserNumber;
import java.util.List;

public class Game {

    private static final int GAME_COUNTS = 3;

    private boolean roundContinue = true;

    private Game() {}

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game();
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.getNumberList();
        do {
            game.startRound(computerNumbers);
        } while (game.roundContinue);
    }

    private void startRound(List<Integer> computerNumbers) {
        UserNumber userNumber = new UserNumber();
        List<Integer> userNumbers = userNumber.getNumberList();
        Judge judge = new Judge(userNumbers, computerNumbers);
        judge.printRoundScore();
        if (judge.countStrike() == GAME_COUNTS) {
            roundContinue = false;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public static String resetGameOrQuit() {
        UserChoice userChoice = new UserChoice();
        return userChoice.getResetOrQuit();
    }
}
