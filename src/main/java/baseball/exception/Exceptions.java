package baseball.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exceptions {
    private static final int NUMBER_ONE = 1;
    private static final int NUMBER_NINE = 9;
    private static final int NUMBER_SIZE = 3;
    private static final int COUNT_NUMBER = 1;

    static List<String> numbers;

    public static boolean respondException(String request) {
        if (!isDigit(request)) {
            return false;
        } else if (!isKoreanLanguage(request)) {
            return false;
        } else if (!isThreeDigit(request)) {
            return false;
        } else if (!isOverLap(request)) {
            return false;
        }
        return true;
    }

    public static boolean isKoreanLanguage(String request) {
        if (request.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
            return false;
        }
        return true;
    }

    public static boolean isDigit(String request) {
        for (int i = 0; i < request.length(); i++) {
            int askii = request.charAt(i) - '0';
            if (askii < NUMBER_ONE || askii > NUMBER_NINE) {
                return false;
            }
        }
        return true;
    }

    public static boolean isThreeDigit(String request) {
        if (request.length() != NUMBER_SIZE) {
            return false;
        }
        return true;
    }

    public static boolean isOverLap(String request) {
        numbers = new ArrayList<String>(Arrays.asList(request.split("")));
        for (int i = 0; i < request.length(); i++) {
            int numberCount = Collections.frequency(numbers, numbers.get(i));
            if (numberCount > COUNT_NUMBER) {
                return false;
            }
        }
        return true;
    }

}
