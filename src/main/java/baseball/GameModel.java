package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.GameRule.DIGITS;
import static baseball.GameRule.RANDOM_MIN;
import static baseball.GameRule.RANDOM_MAX;

public class GameModel {
    public static List<Integer> createComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public static List<Integer> createPlayerNumber() throws IllegalArgumentException {
        String userInput = View.getUserInput(); // 숫자가 아니면 예외 발생
        List<Integer> playerNumber = stringToList(userInput);
        if(!Validator.isValidNumber(playerNumber)){
            throw new IllegalArgumentException();
        }
        return playerNumber;
    }

    public static List<Integer> stringToList(String input) {
        return input.chars()
                .map(i -> i - '0')
                .boxed()
                .collect(Collectors.toList());
    }
}
