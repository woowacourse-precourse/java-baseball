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
        int strikeCount = countStrike(guessNumber);
        int ballCount = countBall(guessNumber);

        System.out.println(resultMessage(strikeCount, ballCount));

        return strikeCount == Rule.SUCCESS_STRIKE_COUNT;
    }

    private int countStrike(List<Integer> guessNumber) {
        int strikeCount = 0;

        for (int i = 0; i < Rule.NUMBER_SIZE; i++) {
            if (Objects.equals(answerNumber.get(i), guessNumber.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private int countBall(List<Integer> guessNumber) {
        int ballCount = 0;

        for (int i = 0; i < Rule.NUMBER_SIZE; i++) {
            if (Objects.equals(answerNumber.get(i), guessNumber.get(i))) {
                continue;
            }
            if (answerNumber.contains(guessNumber.get(i))) {
                ballCount++;
            }
        }

        return ballCount;
    }

    private String resultMessage(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            return ballCount + Message.BALL + " " + strikeCount + Message.STRIKE;
        } else if (strikeCount > 0 && ballCount == 0) {
            return strikeCount + Message.STRIKE;
        } else if (strikeCount == 0 && ballCount > 0) {
            return ballCount + Message.BALL;
        } else {
            return Message.NOTHING;
        }
    }
}
