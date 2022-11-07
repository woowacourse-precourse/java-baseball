package baseball.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.Constants.*;

public class Computer {
    private static List<Integer> generateComputerRandomNumber() {
        List<Integer> computerNumberList = new ArrayList<>();
        for (int i = 0; i < RESULT_SIZE; i++) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (computerNumberList.contains(randomNumber)) {
                i--;
            }
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }
    private static String computerRandomNumberListToString(List<Integer> computerNumberList) {
        return computerNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static String computerRandomNumberResult() {
        return computerRandomNumberListToString(generateComputerRandomNumber());
    }
}
