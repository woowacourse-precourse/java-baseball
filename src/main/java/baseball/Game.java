package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final Computer computer;
    private final User user;

    private Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public static Game start(User user) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = Computer.generateAnswer();
        return new Game(computer, user);
    }

    public boolean run() {
        while (true) {
            user.guess();
            Hint hint = computer.hint(user);
            System.out.println(hint);
            if (hint.correct()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                return restart();
            }
        }
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
