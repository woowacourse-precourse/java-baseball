package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Integer NumberSize = 3;

        GameController controller = new GameController();
        controller.programStart(NumberSize);
    }

}
