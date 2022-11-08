package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;

class Input {
    static final String GAME_GET_NUMBER = "숫자를 입력해주세요 : ";
    static final String EXCEPTION_REPETITION = "중복되는 숫자를 입력했습니다.";
    static final String EXCEPTION_CONTAINS_ZERO = "입력 값에 0이 포함됩니다.";
    static final String EXCEPTION_DIGITS_NOT_3 = "입력 값이 세 자리의 숫자가 아닙니다.";
    static final String EXCEPTION_NOT_NUMBER = "입력 값이 숫자가 아닙니다.";
    static final String EXCEPTION_NOT_1_OR_2 = "입력 값이 1이나 2가 아닙니다.";


    static void validInputInGame(String inputString) throws IllegalArgumentException {
        HashSet<Character> isRepeated = Utils.StringToCharSet(inputString);

        if (isRepeated.size() < 3) {
            System.out.println(EXCEPTION_REPETITION);
            throw new IllegalArgumentException();
        } else if (isRepeated.contains('0')) {
            System.out.println(EXCEPTION_CONTAINS_ZERO);
            throw new IllegalArgumentException();
        } else if (isRepeated.size() != 3) {
            System.out.println(EXCEPTION_DIGITS_NOT_3);
            throw new IllegalArgumentException();
        }
        for (char isInt : isRepeated) {
            int changed = isInt - '0';
            if ((changed > 9) || (changed < 0)) {
                System.out.println(EXCEPTION_NOT_NUMBER);
                throw new IllegalArgumentException();
            }
        }
    }

    static void validInputEndGame(String inputString) throws IllegalArgumentException {
        if (!(inputString.equals("1") || (inputString.equals("2")))) {
            System.out.println(EXCEPTION_NOT_1_OR_2);
            throw new IllegalArgumentException();
        }
    }

    static List<Character> getInputInGame() {
        System.out.print(GAME_GET_NUMBER);
        String input = Console.readLine();
        validInputInGame(input);
        return Utils.StringToCharList(input);
    }

    static char getInputEndGame() throws IllegalArgumentException {
        String input = Console.readLine();
        validInputEndGame(input);
        return input.charAt(0);
    }
}

