package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    int MAX_SCORE = 3;


    private boolean isDigit(Character CharNumber) {
        return Character.isDigit(CharNumber);
    }


    private int toDigit(Character input) {
        validateDigit(input);

        return input - '0';
    }

    private void validateDigit(Character charNumber) {
        if (!isDigit(charNumber)) {
            throw new IllegalArgumentException("not digit");
        }
    }


    private List<Integer> toIntList(String numberString) {
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < numberString.length(); i++) {
            numberList.add(toDigit(numberString.charAt(i)));
        }
        return numberList;
    }

    private List<Integer> getInputNumbers() {
        System.out.printf("숫자를 입력해주세요 : ");
        String input = readLine();
        List<Integer> userNumbers = toIntList(input);

        return userNumbers;
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_SCORE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
