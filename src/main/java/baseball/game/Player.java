package baseball.game;

import baseball.util.BallGenerator;
import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Player {

    private final BallGenerator ballGenerator;

    public Player() {
        this.ballGenerator = new BallGenerator();
    }

    public List<Integer> getPlayerBalls() {
        return ballGenerator.createPlayerBalls();
    }

    public String getPlayerAnswer() {
        String answer = Console.readLine();
        if (!InputValidator.checkProgressAnswer(answer)) {
            throw new IllegalArgumentException();
        }
        return answer;
    }
}
