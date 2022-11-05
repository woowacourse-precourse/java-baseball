package baseball;

public class UserNumberException {

    public void checkUserNumberException(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < inputNumber.length(); i++) {
            if (!('1' <= inputNumber.charAt(i) && inputNumber.charAt(i) <= '9')) {
                throw new IllegalArgumentException();
            }
        }

        int duplicateCheck = inputNumber.charAt(0);
        for (int i = 1; i < inputNumber.length(); i++) {
            if (duplicateCheck == inputNumber.charAt(i)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
