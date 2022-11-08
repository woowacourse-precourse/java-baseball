package baseball;

public class InputException {
    public static void checkThreeNumberException(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("야구 게임의 입력은 이어진 3자리여야 합니다. [ex) 123]");
        }
        for (int i = 0; i < input.length(); i++) {
            if (!checkRange(input.charAt(i))){
                throw new IllegalArgumentException("야구 게임의 입력은 1 ~ 9의 옳바른 범위여야 합니다. [ex) 123]");
            }
        }
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException("야구 게임의 입력은 중복 없이 3자리여야 합니다. [ex) 123]");
        }
    }

    public static void checkRestartNumberException(String input) {
        if (input.length() != 1){
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
        if (!(input.charAt(0) == '1' || input.charAt(0) == '2')){
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }

    private static Boolean checkRange(char c){
        return ('1' <= c && c <= '9');
    }
}
