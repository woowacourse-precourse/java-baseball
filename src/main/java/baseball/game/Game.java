package baseball.game;

import baseball.game.utils.IntegerValidator;
import baseball.game.utils.ScoreBoard;
import java.util.List;

public class Game {

    private Computer computer;
    private User user;

    public Game() {
        this.computer = new Computer();
        this.user = new User();
    }

    public static boolean checkGameOver(ScoreBoard scoreBoard) {
        if (scoreBoard.checkStrikeOut()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }

    public void run() {
        boolean token = true;

        while (token) {

            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> presumeNumbers = user.presume();
            IntegerValidator.validatePresume(presumeNumbers);

            ScoreBoard scoreBoard = computer.scoreCheck(presumeNumbers);
            scoreBoard.printBallAndStrike();

            token = checkGameOver(scoreBoard);
        }
    }
}
