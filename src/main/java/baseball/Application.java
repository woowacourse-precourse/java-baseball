package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static final int GAME_SIZE = 3;

    public static void main(String[] args) {
        int resetInput = 1;

        while (resetInput == 1) {
            doGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            resetInput = continueOrEnd();
        }
    }

    public static void doGame() {
        String input = "";
        Game game = new Game();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!game.isEnd(input)) {
            input = Console.readLine();
            Validation.baseballInput(input);
            game.play(input);
        }
    }

    private static int continueOrEnd() {
        String input;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = Console.readLine();
        Validation.resultInput(input);

        return Integer.parseInt(input);
    }
}
