package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.error.ElementsShouldBeExactly;

import java.util.ArrayList;
import java.util.List;
import baseball.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
