package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> getNewNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static boolean isRightInput(String input) {
        return input.matches("^[1-9]{3}$") && input.charAt(0) != input.charAt(1) && input.charAt(1) != input.charAt(2) && input.charAt(2) != input.charAt(0);
    }
}
