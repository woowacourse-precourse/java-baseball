package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    public static boolean readGameStatus() throws IllegalArgumentException {
        String inputString = Console.readLine();
        if (!inputString.equals("1") && !inputString.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해야합니다.");
        }
        return inputString.equals("1");
    }

    public static String readNumber() throws IllegalArgumentException {
        String inputString = Console.readLine();
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }

        if (inputString.length() != 3) {
            throw new IllegalArgumentException("숫자의 길이는 3이여야 합니다.");
        }
        if (inputString.charAt(0) == inputString.charAt(1) &&
                inputString.charAt(1) == inputString.charAt(2) && inputString.charAt(0) == inputString.charAt(2)) {
            throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력해야 합니다.");
        }

        return inputString;
    }
}
