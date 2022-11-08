package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int RANDOM_NUMBER_DIGIT_SIZE = 3;

    public static void main(String[] args) {
        String input = getInput();
        validateInput(input);

    }

    public static void validateInput(String input) {
        if (input.length() != 3)
            throw new IllegalArgumentException();
        if (!isNumeric(input))
            throw new IllegalArgumentException();
        if (input.contains("0"))
            throw new IllegalArgumentException();
    }

    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }

    private static String getInput() {
        return Console.readLine();
    }

    public static List<Character> tokenizeString(String input) {
        List<Character> tokenizedResult = new ArrayList<>();
        for(int i = 0;i<input.length();i++){
            tokenizedResult.add(input.charAt(i));
        }
        return tokenizedResult;
    }

    public static List<Integer> convertCharListToIntList(List<Character> charList) {
        List<Integer> parseIntResultList = new ArrayList<>();
        for(Character ch : charList){
            parseIntResultList.add(Character.getNumericValue(ch));
        }

        return parseIntResultList;
    }

    public static List<Integer> generateRandomNumber(int digitSize) {
        List<Integer> generatedRandomNumber = new ArrayList<>();
        while (generatedRandomNumber.size() < digitSize) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedRandomNumber.contains(randomNumber)) {
                generatedRandomNumber.add(randomNumber);
            }
        }
        return generatedRandomNumber;
    }
}
