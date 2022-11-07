package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.GameConst.*;
import static baseball.RuleConst.*;

public class GameController {
    private final Computer computer;
    private final User user;

    public GameController() {
        computer = new Computer();
        user = new User();
    }

    private void ready() {
        computer.generateNumber();
        user.generateNumber();
    }

    private boolean isStrike(int index) {
        return computer.getNumbers().get(index)
                .equals(user.getNumbers().get(index));
    }

    private boolean isBall(int index) {
        if (computer.getNumbers().contains(user.getNumbers().get(index))) {
            return !isStrike(index);
        }
        return false;
    }

    private String generateOutput(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (strike == 0 && ball != 0) {
            return ball + "볼";
        } else if (strike != 0 && ball == 0) {
            return strike + "스트라이크";
        } else {
            return ball + "볼 " + strike + "스트라이크";
        }
    }

    private boolean judge() {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (isStrike(i)) {
                strike++;
            } else if (isBall(i)) {
                ball++;
            }
        }

        System.out.println(generateOutput(strike, ball));

        return (strike == THREE_STRIKE);
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int exit = 0;
        while (exit != EXIT_CODE) {
            ready();
            while (!judge()) {
                user.generateNumber();
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            exit = Integer.parseInt(Console.readLine());
        }
    }
}
