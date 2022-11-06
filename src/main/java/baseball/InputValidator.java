package baseball;

/*
 * 입력값을 검증하는 클래스.
 * 1. 세자리수인가.
 * 2. 1 ~ 9 사이의 수를 입력받았는가
 * 3. 세 자리 수가 중복되지 않았는가.
 */
public class InputValidator {

    protected String inputString;
    private int INPUT_LENGTH = 3;
    private String strArr[] = new String[3];
    private String number = "123456789";
    boolean result = true;

    public InputValidator() {
    }

    public InputValidator(String input) {
        this.inputString = input;

        strArr = inputString.split("");
    }

    public boolean checkInput() {
        isInputDuplicated();
        isRightLength();
        isRightNumber();

        return result;
    }

    public boolean isInputDuplicated() {
        if (strArr[0].equals(strArr[1]) || strArr[0].equals(strArr[2])) {
            result = false;
        }
        if (strArr[1].equals(strArr[0]) || strArr[1].equals(strArr[2])) {
            result = false;
        }
        if (strArr[2].equals(strArr[0]) || strArr[2].equals(strArr[1])) {
            result = false;
        }
        return result;
    }

    public boolean isRightLength() {
        if (inputString.length() != INPUT_LENGTH) {
            result = false;
        }
        return result;
    }

    public boolean isRightNumber() {
        for (String strArr_ : strArr) {
            if (!number.contains(strArr_)) {
                result = false;
            }
        }
        return result;
    }
}
