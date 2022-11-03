package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    private static List<Integer> generateComputerNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> readUserNumber() {
        String inputNum = Console.readLine();
        List<String> splittedNum = List.of(inputNum.split(""));
        List<Integer> digits = splittedNum.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return digits;
    }

    public static boolean isValidNumber(List<Integer> digits) {
        if (digits.size() != 3) {
            return false;
        }

        HashSet<Integer> nonDuplicateDigits = new HashSet<>(digits);
        if (nonDuplicateDigits.size() != digits.size()) {
            return false;
        }

        return true;
    }
}
