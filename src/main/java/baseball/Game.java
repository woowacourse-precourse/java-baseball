package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final int RESTART = 1;
    private static final int EXIT = 2;
    private final Computer computer;
    private final User user;

    private Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public static Game start(User user) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = Computer.create();
        return new Game(computer, user);
    }

    public boolean run() {
        while (true) {
            user.guess();
            Status status = computer.status(user);
            System.out.println(status);
            if (status.correct()) {
                System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", Numbers.LENGTH);
                System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n", RESTART, EXIT);
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
        if (input == RESTART) return true;
        if (input == EXIT) return false;
        throw new IllegalArgumentException("잘못된 입력입니다");
    }
}
