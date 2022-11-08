package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator {
    public static final int MAX_NUMBER_OF_CASE = 504;
    public static final int MIN_DIGIT = 1;
    public static final int MAX_DIGIT = 9;
    public static final int NUMBER_LENGTH = 3;
    private static final HashSet<String> numberSet = new HashSet<>();

    public static void initGenerator() {
        numberSet.clear();
    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();

        while (randomNumber.size() < NUMBER_LENGTH) {
            int randomDigit = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT);
            if (!randomNumber.contains(randomDigit)) {
                randomNumber.add(randomDigit);
            }
        }

        return randomNumber;
    }

    public static List<Integer> getRandomNumber() {
        int numberCase = 0;
        List<Integer> randomNumber = new ArrayList<>();
        boolean generationComplete = false;

        while ((numberCase < MAX_NUMBER_OF_CASE) && !generationComplete) {
            randomNumber = generateRandomNumber();
            generationComplete = checkDuplicateNumber(randomNumber);
            numberCase++;
        }

        return randomNumber;
    }

    private static boolean checkDuplicateNumber(List<Integer> randomNumber) {
        boolean noDuplicatedNumber = false;
        String generatedNumber = randomNumber.stream().map(String::valueOf).collect(Collectors.joining());
        if (!numberSet.contains(generatedNumber)) {
            numberSet.add(generatedNumber);
            noDuplicatedNumber = true;
        }
        return noDuplicatedNumber;
    }
}
