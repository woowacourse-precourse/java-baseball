package baseball.game;

import baseball.game.player.Computer;
import baseball.game.player.User;
import java.util.List;

public class Game {

    private Computer computer;
    private User user;

    public void run() {
        this.computer = new Computer();
        this.user = new User();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> presumeNumbers = user.presume();

            ScoreBoard scoreBoard = computer.scoreCheck(presumeNumbers);

            if (scoreBoard.checkStrikeOut()){
                break;
            }
        }
    }
}
