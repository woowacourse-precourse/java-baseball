package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Number {
    private static List<Integer> userNumbers;
    private static List<Integer> computers;

    Number() {
        computers = initComputerNumber();
    }

    Number(String userNumber) {
        Exception.isAllNumeric(userNumber);
        userNumbers = stringToList(userNumber);
    }

    public List<Integer> getComputers() {
        return computers;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    private static List<Integer> stringToList(String userNumber) {
        return userNumber.chars()
                .mapToObj(e -> Integer.parseInt(Character.toString((char) e)))
                .collect(Collectors.toList());
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
