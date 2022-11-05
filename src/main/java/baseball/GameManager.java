package baseball;

import baseball.domain.Computer;
import baseball.view.PrintAndRead;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private Computer computer;

    public GameManager(Computer computer) {
        this.computer = computer;
    }

    public void init() {
        computer.init();
    }

    public void run() {
        PrintAndRead.firstStartPrint();
        PrintAndRead.getBaseballNumber();
    }

}
