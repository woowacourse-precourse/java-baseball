package baseball.utils;

public class NumberChecker {

    public static void checkUserInput(String userInput){
        checkRange(userInput);
        isNumber(userInput);
        hasSameNumber(userInput);
    }
    private static void checkRange(String num){
        if (num.length() != 3){
            throw new IllegalArgumentException("문자의 길이가 다릅니다.");
        }
    }

    private static void isNumber(String num){
        if (!num.matches("[1-9][1-9][1-9]")){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static void hasSameNumber(String num){
        if (num.charAt(0) == num.charAt(1) || num.charAt(1) == num.charAt(2) || num.charAt(0) == num.charAt(2)){
            throw new IllegalArgumentException("반복된 숫자를 입력했습니다.");
        }
    }

    public static void isOneOrTwo(String num){
        if (!(num.equals("1") || num.equals("2"))){
            throw new IllegalArgumentException("입력 값으로 1, 2만 허용됩니다.");
        }
    }
}
