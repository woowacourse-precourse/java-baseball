package baseball.util;

public class Validator {

    public void isValidInput(String input) throws IllegalStateException{

        if (input.length() < 3)
            throw new IllegalArgumentException("입력이 3글자보다 작습니다. 3글자를 입력해주세요.");

        if (input.length() > 3)
            throw new IllegalArgumentException("입력이 3글자보다 큽니다. 3글자를 입력해주세요.");

        if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(2))
            throw new IllegalArgumentException("자릿수별로 각기 다른 숫자를 입력해야 합니다.");
    }
}
