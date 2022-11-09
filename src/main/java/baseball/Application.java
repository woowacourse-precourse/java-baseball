package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        final int QUIT = 2;

        while (true) {
            printInitial();

            Game game = new Game();
            game.run();

            printFinish();

            if(input() == QUIT)
                break;
        }
    }

    static void printInitial() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static void printFinish() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static int input() {
        int in = Integer.parseInt(Console.readLine());
        if (!(in == 1 || in == 2)) {
            System.out.println("잘못된 입력값 입니다. 1 또는 2를 입력하세요.");
            throw new IllegalArgumentException();
        }
        return in;
    }
}
