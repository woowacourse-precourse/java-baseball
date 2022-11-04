package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Computer computer = new Computer();
        computer.random3NumberOutput();

        Player player = new Player();
        player.player3NumberInput();

    }
}
