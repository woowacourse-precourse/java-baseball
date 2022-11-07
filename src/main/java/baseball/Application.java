package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        List<Integer> randomNumbers = getRandomBaseballNumbers();
        String userInput = getUserInput();
    }

    private static String getUserInput() {
        String userInput = Console.readLine();
        isValidInput(userInput);
        return userInput;
    }

    private static void isValidInput(String userInput) {
        Set<Character> notDuplicatedNumbers = new HashSet<>();

        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < userInput.length(); i++) {
            char currChar = userInput.charAt(i);

            if (currChar < '1' || currChar > '9') {
                throw new IllegalArgumentException();
            }

            int setSize = notDuplicatedNumbers.size();
            notDuplicatedNumbers.add(currChar);

            if (setSize == notDuplicatedNumbers.size()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static List<Integer> getRandomBaseballNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }
}
