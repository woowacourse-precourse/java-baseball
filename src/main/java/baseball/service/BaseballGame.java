package baseball.service;

import baseball.model.Computer;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

import static baseball.service.Comparator.compareInputAndRandomNumber;
import static baseball.service.Validator.validRestartInput;

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

    public static boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        validRestartInput(input);

        int play = Integer.parseInt(input);
        if (play == 1) {
            return true;
        } else {
            return false;
        }
    }
}
