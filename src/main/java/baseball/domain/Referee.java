package baseball.domain;

import static baseball.Constants.ZERO;

import java.util.List;

public class Referee {

    private Computer computer;
    private Player player;

    public Referee(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public Result judge() {
        Ball ball = generateBall();
        Strike strike = generateStrike();

        return new Result(ball, strike);
    }

    public Ball generateBall() {
        List<Integer> answer = computer.getAnswerNumbers();
        List<Integer> playerInput = player.getPlayerInput();

        Ball ball = new Ball(ZERO);

        for (int index = 0; index < playerInput.size(); index++) {
            Integer answerDigit = answer.get(index);
            Integer playerInputDigit = playerInput.get(index);

            if (playerInput.contains(answerDigit) && !(playerInputDigit.equals(answerDigit))) {
                ball.add();
            }
        }

        return ball;
    }

    public Strike generateStrike() {
        List<Integer> answer = computer.getAnswerNumbers();
        List<Integer> playerInput = player.getPlayerInput();

        Strike strike = new Strike(ZERO);

        for (int index = 0; index < playerInput.size(); index++) {
            Integer answerDigit = answer.get(index);
            Integer playerInputDigit = playerInput.get(index);

            if (playerInputDigit.equals(answerDigit)) {
                strike.add();
            }
        }

        return strike;
    }
}
