package baseball;

import baseball.constant.Message;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {

    private List<Integer> answerNumber = new ArrayList<>();

    public void createAnswerNumber() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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

        return strikeNumber == 3;
    }

    private int countStrike(List<Integer> guessNumber) {
        int strikeNumber = 0;

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(answerNumber.get(i), guessNumber.get(i))) {
                strikeNumber++;
            }
        }

        return strikeNumber;
    }

    private int countBall(List<Integer> guessNumber) {
        int ballNumber = 0;

        for (int i = 0; i < 3; i++) {
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
