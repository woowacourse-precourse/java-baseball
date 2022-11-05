package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.RuleConst.*;

public class GameController {
    private Computer computer;
    private User user;

    public GameController() {
        computer = new Computer();
        user = new User();
    }

    public void ready() {
        computer.generateNumber();
        user.generateNumber();
    }

    public boolean isStrike(int index) {
        return computer.getNumbers().get(index).equals(user.getNumbers().get(index));
    }

    public boolean isBall(int index) {
        List<Integer> userNumber = user.getNumbers();
        List<Integer> computerNumber = computer.getNumbers();

        if (computerNumber.contains(userNumber.get(index))) {
            return !computerNumber.get(index).equals(userNumber.get(index));
        }
        return false;
    }

    public boolean judge() {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (isStrike(i)) {
                strike++;
            } else {
                if (isBall(i)) {
                    ball++;
                }
            }
        }

        String output = "";
        if (ball != 0) {
            output += ball + "볼 ";
        }
        if (strike != 0) {
            output += strike + "스트라이크";
        }
        if (strike == 0 && ball == 0) {
            output = "낫싱";
        }
        if (strike == 3) {
            output += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            System.out.println(output);
            return true;
        }
        System.out.println(output);
        return false;
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int exit = 0;
        while (exit != 2) {
            ready();
            while (!judge()) {
                user.generateNumber();
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            exit = Integer.parseInt(Console.readLine());
        }
    }
}
