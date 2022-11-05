package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    final Computer computer;
    final User user;

    private Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public static Game start(User user) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = Computer.generateAnswer();
        return new Game(computer, user);
    }

    public void hint(int strike, int ball) {
        StringBuilder hint = new StringBuilder();
        if (ball > 0) {
            hint.append(ball).append("볼 ");
        }
        if (strike > 0) {
            hint.append(strike).append("스트라이크 ");
        }
        if (hint.length() == 0) {
            hint.append("낫싱");
        }
        System.out.println(hint.toString().trim());
    }

    public boolean restart() {
        try {
            int input = Integer.parseInt(Console.readLine());
            return restart(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }
    }

    private boolean restart(int input) {
        if (input == 1) return true;
        if (input == 2) return false;
        throw new IllegalArgumentException("잘못된 입력입니다");
    }
}
