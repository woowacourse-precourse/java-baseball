package baseball;


import static baseball.Constant.GAME_END;
import static baseball.Constant.GAME_START;

public class Application {




    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(GAME_START);

        Game.playGame();

    }

    public static void end() {

//        System.out.println(GAME_END);

        throw new RuntimeException(GAME_END);


    }

}
