package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int going = 1;

        while (going == 1) {
            baseballGame();
        }
    }

    static void baseballGame() {

        List<Integer> numbers = makeRandomNumbers();
    }

    static List<Integer> makeRandomNumbers() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
