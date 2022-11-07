package baseball.service;

import baseball.console.Input;
import baseball.console.Output;
import baseball.entity.Computer;
import baseball.entity.User;

import java.util.HashSet;

public class Game {
    private final String startMessage = "숫자 야구 게임을 시작합니다.";
    private User user;
    private Computer computer;

    public Game() {
        System.out.println(startMessage);
        user = new User();
        computer = new Computer();
    }

    public void start() {
        computer.setAnswer();
        do {
            user.setNumber(Input.get());
        } while (!isCorrect());

        String restart = Input.restart();
        if (restart.equals("1")) {
            start();
        }
        System.out.println("게임 종료");
    }

    private boolean isCorrect() {
        int strike = countStrike();
        int ball = countBall();
        Output.print(ball, strike);
        if (strike == 3) {
            return true;
        }
        return false;
    }

    private int countBall() {
        String number = user.getNumber();
        String answer = computer.getAnswer();

        HashSet<Character> set = new HashSet<>();
        for (char c : answer.toCharArray()) {
            set.add(c);
        }
        int ballCount = 0;
        for (int index = 0; index < 3; index++) {
            if (number.charAt(index) != answer.charAt(index) && set.contains(number.charAt(index))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private int countStrike() {
        String number = user.getNumber();
        String answer = computer.getAnswer();
        if (number.equals(answer)) {
            return 3;
        }

        int strikeCount = 0;
        for (int index = 0; index < 3; index++) {
            if (number.charAt(index) == answer.charAt(index)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
