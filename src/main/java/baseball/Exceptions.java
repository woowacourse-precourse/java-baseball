package baseball;

import fixed.FixedList;

public class Exceptions {

    public static void checkInputIsNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 입력이 아닙니다.");
        }
    }

    public static void checkInputIsTooLong(String userInput) {
        if (userInput.length() > FixedList.LENGTH) {
            throw new IllegalArgumentException("입력이 너무 깁니다. 숫자 3자리를 입력하세요.");
        }
    }

    public static void checkInputIsTooShort(String userInput) {
        if (userInput.length() < FixedList.LENGTH) {
            throw new IllegalArgumentException("입력이 너무 짧습니다. 숫자 3자리를 입력하세요.");
        }
    }

    public static void checkOpinionMessage(String userOpinion) {
        if (!(userOpinion.equals("1") || userOpinion.equals("2")))
            throw new IllegalArgumentException("1 : 게임 새로 시작, 2 : 게임 종료");
    }
}
