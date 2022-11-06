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

        }
    }

}
