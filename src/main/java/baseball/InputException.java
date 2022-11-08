package baseball;

public class InputException {
    public static void checkThreeNumberException(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("야구 게임의 입력은 이어진 3자리여야 합니다. [ex) 123]");
        }
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException("야구 게임의 입력은 중복 없이 3자리여야 합니다. [ex) 123]");
        }
    }
}
