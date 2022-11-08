package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static final String CONTINUE = "1";
    public static final String EXIT = "2";
    private static String status;

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            game.play();
            updateStatusAsInput();
        } while (status.equals(CONTINUE));
    }

    private static void updateStatusAsInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        validateInput(input);
        status = input;
    }

    private static void validateInput(String input) {
        if (!input.equals(CONTINUE) && !input.equals(EXIT)) {
            throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
        }
    }
}
