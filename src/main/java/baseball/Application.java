package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameSystem game = new GameSystem();

        game.GameStart();

        while(game.GameStartAgain()) {
            game.initValue();

            game.GamePlay();
        }

    }



}
