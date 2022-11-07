package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    final static String QUIT_GAME_CONDITION = "2";
    final static ExceptionFor4 exceptionFor4 = new ExceptionFor4();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            Game game = new Game();
            game.play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String repeat = Console.readLine();
            exceptionFor4.checkException(repeat);
            if (repeat.equals(QUIT_GAME_CONDITION)) {
                break;
            }
        }
    }
}
