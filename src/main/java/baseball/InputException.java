package baseball;

public class InputException {
    public static void checkThreeNumberException(String input) {
        if (input.length() != 3) {
            exceptionThreeNumberInput();
        }
        for (int i = 0; i < input.length(); i++) {
            if (!checkRange(input.charAt(i))){
                exceptionThreeNumberInput();
            }
        }
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
            exceptionThreeNumberInput();
        }
    }

    public static void checkRestartNumberException(String input) {
        if (input.length() != 1){
            exceptionRestartNumberInput();
        }
        if (!(input.charAt(0) == '1' || input.charAt(0) == '2')){
            exceptionRestartNumberInput();
        }
    }

    private static Boolean checkRange(char c){
        return ('1' <= c && c <= '9');
    }

    private static void exceptionThreeNumberInput(){
        throw new IllegalArgumentException("옳바른 숫자를 입력해주세요. ex) 123");
    }

    private static void exceptionRestartNumberInput(){
        throw new IllegalArgumentException("옳바른 숫자를 입력해주세요. ex) 1 or 2");
    }
}
