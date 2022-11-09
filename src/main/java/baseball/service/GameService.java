package baseball.service;

import baseball.domain.*;
import baseball.domain.Number;

import java.util.List;

public class GameService {

    private Balls computer;
    private final Number number;
    private boolean answer;

    public GameService(Number number) {
        this.number = number;
    }

    private void init() {
        computer = new Balls(number.getNumberList());
        this.answer = false;
    }

    public void startGame() {
        init();
    }

    public String checkInput(List<Ball> input) {

        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < input.size(); i++) {
            Ball ball = input.get(i);

            strikeCount += countStrike(ball, i);
            ballCount += countBall(ball, i);
        }

        if (strikeCount == Config.MAX_BALLS_SIZE) {
            answer = true;
        }

        return Hint.getHint(ballCount, strikeCount).getMessage(ballCount, strikeCount);
    }

    public int countStrike(Ball ball, int position) {
        if (computer.isExactlyCorrect(ball, position)) {
            return 1;
        }
        return 0;
    }

    public int countBall(Ball ball, int position) {
        if (computer.containBall(ball, position)) {
            return 1;
        }
        return 0;
    }

    public boolean isAnswer() {
        return answer;
    }
}
