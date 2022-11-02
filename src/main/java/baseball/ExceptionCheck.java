package baseball;

public class ExceptionCheck {

    public void verificationLength(String userInput) {
        if (userInput.length() > 3) {
            throw new IllegalArgumentException();
        }
    }

    public void verificationDuplicate(String userInput) {
        char[] inputToCharArr = userInput.toCharArray();
        for (char seq : inputToCharArr) {
            if (userInput.contains(String.valueOf(seq))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void verificationInputZero(String userInput) {
        if (userInput.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    public void verificationCharDetect(String userInput) {
        for (int seq = 0; seq < userInput.length(); seq++) {
            if (!(userInput.charAt(seq) >= 49) && !(userInput.charAt(seq) <= 59)) {
                throw new IllegalArgumentException();
            }
        }
    }

}