package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class Number {
    private static List<Integer> userNumbers;
    private static List<Integer> computers;

    public static List<Integer> getComputers() {
        return computers;
    }

    public static List<Integer> getUserNumbers() {
        return userNumbers;
    }

    private List<Integer> initComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addRandomNumber(randomNumber, computer);
        }
        return computer;
    }

    private void addRandomNumber(int randomNumber, List<Integer> computer) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
}
