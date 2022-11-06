package baseball.game;

import baseball.game.utils.InputValidator;
import baseball.game.utils.StringConverter;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    public void startGame() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean token = true;
        while (token) {
            Game game = new Game();
            game.run();

            token = checkRestartGame();
        }
    }

    public static boolean checkRestartGame() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = StringConverter.toInteger(Console.readLine().strip());
        InputValidator.validateRestartChoice(choice);
        return checkChoice(choice);
    }

    private static boolean checkChoice(int choice) {
        if (choice == 1) {
            return true;
        }
        return false;
    }
}
