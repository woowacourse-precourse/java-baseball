package baseball.service;

import baseball.Constant;
import baseball.model.Answer;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

public class GameService {

    public void start() {
        Answer answer = new Answer();
        System.out.print("숫자를 입력해주세요 : ");

        String inputText = Console.readLine();
        User user = new User(inputText);

        int strike = countingStrike(answer, user);
        int ball = countingBall(countingContainAnswer(answer, user), strike);

        System.out.println(ball + "볼" + strike + "스트라이크");
    }

    private int countingStrike(Answer answer, User user) {
        int count = 0;
        for (int i = 0; i < Constant.DIGIT_SIZE; i++) {
            if (answer.getValue().get(i) == user.getInputNumberList().get(i)) {
                count++;
            }
        }
        return count;
    }

    private int countingBall(int containCount, int strike) {
        return containCount - strike;
    }

    private int countingContainAnswer(Answer answer, User user) {
        int count = 0;
        for (int i = 0; i < Constant.DIGIT_SIZE; i++) {
            if (answer.getValue().contains(user.getInputNumberList().get(i))) {
                count++;
            }
        }
        return count;
    }
}
