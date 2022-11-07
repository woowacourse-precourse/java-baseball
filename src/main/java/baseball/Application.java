package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Constant.START_PROGRAM;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        System.out.println(START_PROGRAM);
        game.startProgram();
    }
}
