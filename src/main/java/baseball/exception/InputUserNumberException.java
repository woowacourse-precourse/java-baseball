package baseball.exception;


public class InputUserNumberException {

    private final int PROPER_LENGTH = 3;


    private void checkInputSizeThreeNumber(String userNumber) {
        if (userNumber.length() != PROPER_LENGTH) {
            throw new IllegalArgumentException("3자리의 수를 입력해주세요.");
        }
    }


}
