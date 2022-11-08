package baseball.computer.generator;

import baseball.rule.NumberConstant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RandomNumberGenerator {
    public static final int MAX_NUMBER_OF_CASE = 504;
    private static final HashSet<List<Integer>> numberSet = new HashSet<>();

    public static void initGenerator() {
        numberSet.clear();
    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();

        while (randomNumber.size() < NumberConstant.NUMBER_LENGTH) {
            int randomDigit = Randoms.pickNumberInRange(NumberConstant.MIN_DIGIT, NumberConstant.MAX_DIGIT);
            checkDuplicateDigit(randomDigit, randomNumber);
        }

        return randomNumber;
    }

    private static void checkDuplicateDigit(int randomDigit, List<Integer> randomNumber) {
        if (!randomNumber.contains(randomDigit)) {
            randomNumber.add(randomDigit);
        }
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

        if (!numberSet.contains(randomNumber)) {
            numberSet.add(randomNumber);
            noDuplicatedNumber = true;
        }

        return noDuplicatedNumber;
    }
}
