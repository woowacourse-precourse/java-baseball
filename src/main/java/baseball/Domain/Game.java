package baseball.Domain;

import baseball.Util.RandomNumber;

import java.util.ArrayList;

public class Game {
    public int strike;
    public int ball;
    public ArrayList<Integer> answerNumber;

    public void setAnswerNumber() {
        RandomNumber randomNumber = new RandomNumber();
        answerNumber = randomNumber.setRandomNumber();
    }

    public void calculateStrike(ArrayList<Integer> userNumber) {
        strike = 0;
        for (int index = 0; index < 3; index++) {
            if (answerNumber.get(index) == userNumber.get(index)) {
                strike++;
            }
        }
    }

    public void calculateBall(ArrayList<Integer> userNumber) {
        ball = 0;
        for (int index = 0; index < 3; index++) {
            if (answerNumber.contains(userNumber.get(index)) && answerNumber.get(index) != userNumber.get(index)) {
                ball++;
            }
        }
    }
}
