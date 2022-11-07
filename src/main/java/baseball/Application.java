package baseball;

import baseball.game.Game;
import baseball.util.UserInput;

public class Application {
    public static void main(String[] args) {

        UserInput userInput = new UserInput();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            Game game = new Game();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (!userInput.isStart()) {
                break;
            }
        }
    }
}
