package baseball;

public class InputVerifier {
    public boolean verifyInput(String input) {
        if (isNumber(input) && isThreeDigits(input) && isDistinctDigits(input)) {
            return true;
        }
        return false;
    }
}
