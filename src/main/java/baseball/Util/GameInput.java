package baseball.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameInput {

    private static GameInput instance;

    public static GameInput getInstance() {
        if (instance == null) {
            instance = new GameInput();
        }
        return instance;
    }

    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public void isLegalInput(String input) throws IllegalArgumentException {
        if (isOnlyNumber(input) && isDontContainsZero(input) && isThreeDigit(input) && isAllDifferent(input)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public boolean isOnlyNumber(String input) {
        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(input);
        return !matcher.find();
    }

    public boolean isDontContainsZero(String input) {
        return !input.contains("0");
    }

    public boolean isThreeDigit(String input) {
        return (input.length() == 3);
    }

    public boolean isAllDifferent(String input) {
        char firstChar = input.charAt(0);
        char secondChar = input.charAt(1);
        char thirdChar = input.charAt(2);
        if (firstChar == secondChar || secondChar == thirdChar || firstChar == thirdChar) {
            return false;
        }
        return true;
    }

    public String convertIntToString(int intValue) {
        return String.valueOf(intValue);
    }
}
