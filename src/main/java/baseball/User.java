package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public static String input;
    public static int nextRound;
    public static int[] userNumber;

    // 사용자에게 3자리의 수(문자열 형태)로 리턴하는 메소드
    public static int[] inputNumber() {
        input = Console.readLine();

        if(input.length() != 3) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }

        if(input.contains("0")) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }

        for(int i=0; i<3; i++) {
            checkNumeric(input.charAt(i));
        }

        userNumber = stringToInt(input);
        return userNumber;
    }

    public static void checkNumeric(char c) {
        if(Character.isDigit(c)) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }

    public static int[] stringToInt(String inputNumber) {
        int[] number = new int[3];

        for(int i=0; i<3; i++) {
            number[i] = Character.getNumericValue(inputNumber.charAt(i));
        }

        return number;
    }

    public static int choiceNextRound() {
        nextRound = Integer.parseInt(Console.readLine());
        return nextRound;
    }
}