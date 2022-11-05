package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static Boolean isEnd = false;

    public static void main(String[] args) {
        isEnd = false;

        while (isEnd.equals(false)) {
            Game game = new Game();
            game.start();
            setIsEnd(getInput());
        }
    }

    private static String getInput() {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("입력값이 없습니다. 애플리케이션을 종료합니다.");
        }
    }

    private static void setIsEnd(String input) {
        if ("1".equals(input)) {
            isEnd = false;
        } else if ("2".equals(input)) {
            isEnd = true;
        } else {
            throw new IllegalArgumentException("잘못된 입력값입니다. 애플리케이션을 종료합니다.");
        }
    }
}
