package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.User;
import baseball.utils.RandomNumberGenerator;
import baseball.view.SystemMessage;

import java.util.ArrayList;
import java.util.Objects;

import static baseball.view.UserInput.getUserInputNumber;

public class BaseballGameService {
    BaseballGame baseballGame;
    User user = new User();

    public void setBaseballGame() {
        baseballGame = new BaseballGame(RandomNumberGenerator.getRandomNumberList());
    }

    public void playingBaseballGame() {
        int strike = 0;
        while (strike != 3) {
            play();
            SystemMessage.printResult(baseballGame.getBallCount(), baseballGame.getStrikeCount());
            strike = baseballGame.getStrikeCount();
        }
    }

    private void play() {
        baseballGame.initBaseballGame();

        SystemMessage.requestInputNumberMessage();
        user.setUserNumbers(getUserInputNumber());
        getResult(baseballGame.getAnswerNumbers(), user.getUserNumbers());
    }

    private void getResult(ArrayList<Integer> answerNumber, ArrayList<Integer> userNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answerNumber.size(); i++) {
            for (int j = 0; j < userNumber.size(); j++) {
                strike = calculateStrike(i, j, answerNumber, userNumber, strike);
                ball = calculateBall(i, j, answerNumber, userNumber, ball);
            }
        }

        baseballGame.setBallCount(ball);
        baseballGame.setStrikeCount(strike);
    }

    private int calculateStrike(int i, int j, ArrayList<Integer> answerNumber, ArrayList<Integer> userNumber, int strike) {
        // 같은 수가 같은 자리에 있으면 스트라이크
        if (i == j && (Objects.equals(answerNumber.get(i), userNumber.get(j)))) {
            strike += 1;
        }
        return strike;
    }

    private int calculateBall(int i, int j, ArrayList<Integer> answerNumber, ArrayList<Integer> userNumber, int ball) {
        // 같은 수가 다른 자리에 있으면 볼
        if (i != j && (Objects.equals(answerNumber.get(i), userNumber.get(j)))) {
            ball += 1;
        }
        return ball;
    }
}
