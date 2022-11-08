package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    final static String QUIT_GAME_CONDITION = "2";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            Game game = new Game();
            game.play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String repeatOption = Console.readLine();
            GameRepeatInputException.verify(repeatOption);
            if (repeatOption.equals(QUIT_GAME_CONDITION)) {
                break;
            }
        }
    }
}