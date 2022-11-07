package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    SystemMessage systemMessage = new SystemMessage();

    void start() {
        System.out.println(systemMessage.START_GAME_MESSAGE);
        final List<Integer> computerNumbers = setThreeLengthNumberWithoutDuplication();
    }

    List<Integer> setThreeLengthNumberWithoutDuplication() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    List<String> getNumber() {
        System.out.print(systemMessage.INSERT_NUMBER_MESSAGE);
        List<String> numberList = new ArrayList<>(Arrays.asList(Console.readLine().split("")));
        return numberList;
    }
    void result (List<String> numberList) {

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
