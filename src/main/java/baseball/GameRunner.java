package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameRunner {
    public static void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        String endInput="1";

        while(endInput.equals("1")){
            Game game = new Game();
            game.start();
            endInput = game.getEndInput();
        }
    }
}
