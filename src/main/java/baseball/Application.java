package baseball;


import static baseball.Constant.GAME_END;
import static baseball.Constant.GAME_OVER;
import static baseball.Constant.GAME_START;

public class Application {

    public static String end() {
        return GAME_END;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(GAME_START);

        Game.playGame();

        System.out.println(GAME_OVER);

    }



}
