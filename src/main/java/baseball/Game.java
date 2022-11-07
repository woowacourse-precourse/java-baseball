package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    SystemMessage systemMessage = new SystemMessage();
    List<Integer> resultNumbers;
    void start() {
        System.out.println(systemMessage.START_GAME_MESSAGE);
        resultNumbers = setThreeLengthNumberWithoutDuplication();
    }

    List<Integer> setThreeLengthNumberWithoutDuplication() {
        List<Integer> resultNumbers = new ArrayList<>();
        while (resultNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!resultNumbers.contains(randomNumber)) {
                resultNumbers.add(randomNumber);
            }
        }
        return resultNumbers;
    }

    List<Integer> getNumber() {
        System.out.print(systemMessage.INSERT_NUMBER_MESSAGE);
        List<Integer> numberList = Arrays.stream(Console.readLine().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numberList;
    }

    char gameRestartController() {
        System.out.println(systemMessage.RESTART_GAME_MESSAGE);
        String inputRestartValue = Console.readLine();

        if (inputRestartValue.length() == 1) {
            return inputRestartValue.charAt(0);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
