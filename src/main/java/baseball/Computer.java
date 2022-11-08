package baseball;

import baseball.constant.Message;
import baseball.constant.Rule;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {

    private List<Integer> answerNumber = new ArrayList<>();

    public void createAnswerNumber() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < Rule.NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Rule.MIN_DIGIT_NUMBER, Rule.MAX_DIGIT_NUMBER);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        this.answerNumber = answer;
    }

    public boolean checkResult(List<Integer> guessNumber) {
        int strikeNumber = countStrike(guessNumber);
        int ballNumber = countBall(guessNumber);

        System.out.println(resultMessage(strikeNumber, ballNumber));

        return strikeNumber == Rule.SUCCESS_STRIKE_COUNT;
    }

    private int countStrike(List<Integer> guessNumber) {
        int strikeNumber = 0;

        for (int i = 0; i < Rule.NUMBER_SIZE; i++) {
            if (Objects.equals(answerNumber.get(i), guessNumber.get(i))) {
                strikeNumber++;
            }
        }

        return strikeNumber;
    }

    private int countBall(List<Integer> guessNumber) {
        int ballNumber = 0;

        for (int i = 0; i < Rule.NUMBER_SIZE; i++) {
            if (Objects.equals(answerNumber.get(i), guessNumber.get(i))) {
                continue;
            }
            if (answerNumber.contains(guessNumber.get(i))) {
                ballNumber++;
            }
        }

        return ballNumber;
    }

    private String resultMessage(int strikeNumber, int ballNumber) {
        if (strikeNumber > 0 && ballNumber > 0) {
            return ballNumber + Message.BALL + " " + strikeNumber + Message.STRIKE;
        } else if (strikeNumber > 0 && ballNumber == 0) {
            return strikeNumber + Message.STRIKE;
        } else if (strikeNumber == 0 && ballNumber > 0) {
            return ballNumber + Message.BALL;
        } else {
            return Message.NOTHING;
        }
    }
}
