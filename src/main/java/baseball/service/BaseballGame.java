package baseball.service;

import baseball.model.Computer;
import baseball.model.User;

import static baseball.service.Comparator.compareInputAndRandomNumber;

public class BaseballGame {

    public static void startNewGame() {
        boolean isCorrect = false;
        Computer computer = new Computer();
        while (!isCorrect) {
            System.out.print("숫자를 입력해주세요 : ");
            User user = new User();
            isCorrect = compareInputAndRandomNumber(computer, user);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
