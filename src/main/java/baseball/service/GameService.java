package baseball.service;

import baseball.system.SystemValue;
import baseball.system.SystemMessage;
import baseball.model.Answer;
import baseball.model.User;
import java.util.List;

public class GameService {

    public void start() {
        boolean correct = false;
        Answer answer = new Answer();
        while (!correct) {
            String inputText = SystemMessage.inputNumberMessage();
            User user = new User(inputText);

            int strike = countingStrike(answer.getValue(), user.getInputNumberList());
            int ball = countingBall(countingContainAnswer(answer.getValue(), user.getInputNumberList()), strike);
            correct = isCorrect(ball, strike);
        }
    }

    private boolean isCorrect(int ball, int strike) {
        if (ball == 0 && strike == 3) {
            SystemMessage.printStrike(3);
            return true;
        }
        printHint(ball, strike);
        return false;
    }

    private void printHint(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            SystemMessage.printNothing();
        }
        if (ball == 0 && strike != 0) {
            SystemMessage.printStrike(strike);
        }
        if (strike == 0 && ball != 0) {
            SystemMessage.printBall(ball);
        }
        if (ball != 0 && strike != 0) {
            SystemMessage.printBallAndStrike(ball, strike);
        }
    }

    private int countingStrike(List<Integer> answerList, List<Integer> userInputList) {
        int count = 0;
        for (int i = 0; i < SystemValue.DIGIT_SIZE; i++) {
            if (answerList.get(i) == userInputList.get(i)) {
                count++;
            }
        }
        return count;
    }

    private int countingContainAnswer(List<Integer> answerList, List<Integer> userInputList) {
        int count = 0;
        for (int i = 0; i < SystemValue.DIGIT_SIZE; i++) {
            if (answerList.contains(userInputList.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int countingBall(int containCount, int strike) {
        return containCount - strike;
    }
}
