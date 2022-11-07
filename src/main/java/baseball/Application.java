package baseball;

import baseball.entity.Game;
import baseball.entity.NumberBaseball;

public class Application {
    public static void main(String[] args) {
        Game numberBaseball = new NumberBaseball();
        numberBaseball.run();
    }
}
