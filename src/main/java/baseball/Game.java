package baseball;

import java.util.List;

public class Game {
    public static final int NUMBER_OF_DIGIT = 3;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> numComputer = NumComputerPicker.pickNumComputer();

    }
}
