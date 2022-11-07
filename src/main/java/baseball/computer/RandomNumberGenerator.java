package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator {
    public static final int MAX_NUMBER_OF_CASE = 504;
    private static final HashSet<String> numberSet = new HashSet<>();
    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public static List<Integer> getRandomNumber() {
        int numberCase = 0;
        List<Integer> randomNumbers = new ArrayList<>();
        boolean generationComplete = false;
        while ((numberCase < MAX_NUMBER_OF_CASE) && !generationComplete) {
            randomNumbers = generateRandomNumbers();
            generationComplete = checkDuplicateNumbers(randomNumbers);
            numberCase++;
        }
        return randomNumbers;
    }

    private static boolean checkDuplicateNumbers(List<Integer> randomNumbers) {
        boolean noDuplicatedNumbers = false;
        String generatedNumbers = randomNumbers.stream().map(String::valueOf).collect(Collectors.joining());
        if (!numberSet.contains(generatedNumbers)) {
            numberSet.add(generatedNumbers);
            noDuplicatedNumbers = true;
        }
        return noDuplicatedNumbers;
    }
}
