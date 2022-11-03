package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input;
        int flag = 1;

        while (flag == 1) {
            doGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public static void doGame() {
        String input = "";
        Game game = new Game();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!game.isEnd(input)) {
            input = Console.readLine();
            if (InputCheck.isInputError(input)) {
                throw new IllegalArgumentException("입력오류");
            }
            game.play(input);
        }
    }

    private static int continueOrEnd() {
        String input;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = Console.readLine();
        // TODO: 종료 전용 인풋체크 만들어라
        return Integer.parseInt(input);
    }
}
