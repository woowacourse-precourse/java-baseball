package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    private static final int NUMBERS_SIZE = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    public static List<Integer> selectComputerNumber(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
