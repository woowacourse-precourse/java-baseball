package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static final int RESTART = 1;
    public static final int END = 2;

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("숫자 야구 게임을 시작합니다.");
        game.playGame();
        restartOrEndGame();
    }

    public static void restartOrEndGame() {
        int userChoiceRestartOrEnd = 0;
        Game game;
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userChoiceRestartOrEnd = Integer.parseInt(Console.readLine());
            ValidateGameComponent.validUserRestartOrEndGame(userChoiceRestartOrEnd);
            if (userChoiceRestartOrEnd == END) {
                break;
            } else if (userChoiceRestartOrEnd == RESTART) {
                game = new Game();
                game.playGame();
            }
        }
    }
}

