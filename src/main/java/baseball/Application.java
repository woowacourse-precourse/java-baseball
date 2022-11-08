package baseball;

import baseball.controller.Controller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller game = new Controller();
        boolean play = true;
        while(play){
            game.playGame();
            play = !game.getGameEnd();
        }

    }
}