package baseball;

public class ExceptionCheck {

    public void verificationLength(String userInput) {
        if (userInput.length() > 3) {
            throw new IllegalArgumentException();
        }
    }

    public void verificationDuplicated(String userInput) {
        if (userInput.charAt(0) == userInput.charAt(1) || userInput.charAt(0) == userInput.charAt(2)
                || userInput.charAt(1) == userInput.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    public void verificationInputZero(String userInput) {
        if (userInput.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    public void verificationCharDetect(String userInput) {
        for (int seq = 0; seq < userInput.length(); seq++) {
            if (!(userInput.charAt(seq) >= 49) || !(userInput.charAt(seq) <= 58)) {
                throw new IllegalArgumentException();
            }
        }
    }

}