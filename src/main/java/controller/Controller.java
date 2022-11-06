package controller;

import java.util.HashMap;
import java.util.List;
import model.Computer;
import model.GamePlayer;

public class Controller {

    public static final char MAXIMUM_RANGE = '9';
    public static final char MINIMUM_RANGE = '1';
    public static final int DIGITS = 3;

    public static boolean validateNumbers(String numbers) {
        if (!isLengthCorrect(numbers)) {
            return false;
        }
        if (!isInRange(numbers)) {
            return false;
        }
        if (!differFromEachOther(numbers)) {
            return false;
        }
        return true;
    }

    private static boolean isLengthCorrect(String str) {
        if (str.length() != DIGITS) {
            return false;
        }
        return true;
    }

    private static boolean isInRange(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch < MINIMUM_RANGE || MAXIMUM_RANGE < ch) {
                return false;
            }
        }
        return true;
    }

    private static boolean differFromEachOther(String str) {
        for (int i = 1; i < str.length(); i++) {
            char frontLetter = str.charAt(i - 1);
            String backString = str.substring(i);
            if (existsCharacter(frontLetter, backString)) {
                return false;
            }
        }
        return true;
    }

    private static boolean existsCharacter(char findCharacter, String str) {
        for (int i = 0; i < str.length(); i++) {
            char characterInString = str.charAt(i);
            if (compareCharacters(findCharacter, characterInString) == 0) {
                return true;
            }
        }
        return false;
    }

    private static int compareCharacters(char ch1, char ch2) {
        return (int) (ch1 - ch2);
    }

    public static void handleException(boolean result) {
        if (!result) {
            throw new IllegalArgumentException("잘못된 값을 입력하여 종료합니다.");
        }
    }

    public static HashMap<String, Integer> compareTo(Computer computer, GamePlayer gamePlayer) {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("strike", 0);
        result.put("ball", 0);

        int[] source = gamePlayer.numbers;
        List<Integer> destination = computer.getRandomNumbers();
        boolean[] collection = computer.getCollection();
        for (int i = 0; i < source.length; i++) {
            Integer target = destination.get(i);
            int currentNumber = source[i];
            Integer currentStrike = result.get("strike");
            Integer currentBall = result.get("ball");

            if (target == currentNumber){
                currentStrike++;
            } else if (collection[currentNumber]){
                currentBall++;
            }
            result.replace("strike", currentStrike);
            result.replace("ball", currentBall);
        }
        return result;
    }
}
