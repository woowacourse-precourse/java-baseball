package baseball;

import camp.nextstep.edu.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computer;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        init();
    }

    private static void init() {
        if (computer == null) computer = new ArrayList<>();

        while (computer.size() <= 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(number)) computer.add(number);
        }
    }

}
