package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameModel {
    private static final int DIGITS = Rule.DISITS.getValue();
    private static final int RANDOM_MIN = Rule.RANDOM_MIN.getValue();
    private static final int RANDOM_MAX = Rule.RANDOM_MAX.getValue();
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

    public static List<Integer> createPlayerNumber(){
        String userInput = View.getUserInput(); // 숫자인지 확인
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
