package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
public class Application {
    public static void main(String[] args) {

    }
    static List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber;
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
