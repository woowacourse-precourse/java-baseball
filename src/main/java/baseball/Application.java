package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static User user = new User();
    private static final Character RESTART = '1';

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new GameContext().game();
        Character retry = RESTART;

        while (retry == RESTART) {
            game.start(new Computer(), user);
            retry = user.inputRetry();
        }
    }
}
