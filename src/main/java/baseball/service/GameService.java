package baseball.service;

import baseball.Constant;
import baseball.model.Answer;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameService {

    public void start() {
        Answer answer = new Answer();
        System.out.print("숫자를 입력해주세요 : ");

        String inputText = Console.readLine();
        User user = new User(inputText);

        int strike = countingStrike(answer.getValue(), user.getInputNumberList());
        int ball = countingBall(countingContainAnswer(answer.getValue(), user.getInputNumberList()), strike);

        System.out.println(ball + "볼" + strike + "스트라이크");
    }

    private int countingStrike(List<Integer> answerList, List<Integer> userInputList) {
        int count = 0;
        for (int i = 0; i < Constant.DIGIT_SIZE; i++) {
            if (answerList.get(i) == userInputList.get(i)) {
                count++;
            }
        }
        return count;
    }

    private int countingBall(int containCount, int strike) {
        return containCount - strike;
    }

    private int countingContainAnswer(List<Integer> answerList, List<Integer> userInputList) {
        int count = 0;
        for (int i = 0; i < Constant.DIGIT_SIZE; i++) {
            if (answerList.contains(userInputList.get(i))) {
                count++;
            }
        }
        return count;
    }
}
