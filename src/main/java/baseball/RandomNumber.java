package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private static List<Integer> randomNumber;
    private static Set<Integer> randomNumberSet;
    private static final String regex = "^[1-9]{3}$";
    private static final int NUMBERSIZE = 3;

    public RandomNumber() {
    }

    public List<Integer> getRandomNumberList() {
        return randomNumber;
    }

    public void createRandomNumber() {
        randomNumberSet = new LinkedHashSet<>();
        while (randomNumberSet.size() < NUMBERSIZE) {
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberSet.contains(pickNumber)) {
                randomNumberSet.add(pickNumber);
            }
        }
        randomNumber = new ArrayList<>(randomNumberSet);
    }

    public void createUserRandomNumber() {
        if (!randomNumber.isEmpty()) {
            randomNumber.clear();
        }
        String userInput = Console.readLine();
        checkUserInput(userInput);
        randomNumber = new ArrayList<>(randomNumberSet);
    }

    private static void checkUserInput(String userInput) {
        if (!userInput.matches(regex)) {
            throw new IllegalArgumentException();
        }
        randomNumberSet.clear();
        for (int i = 0; i < userInput.length(); i++) {
            randomNumberSet.add(userInput.charAt(i) - '0');
        }
        if (randomNumberSet.size() != NUMBERSIZE) {
            throw new IllegalArgumentException();
        }
    }
}
