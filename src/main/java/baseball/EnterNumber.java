package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnterNumber {

    private List<Integer> enterNumber;

    public EnterNumber() {
        enterNumber = new ArrayList<>();
    }
    public List<Integer> getEnterNumber() {
        return this.enterNumber;
    }
    public boolean enterNumberLengthExcept(String userEnterNumber) {
        boolean isEnterNumberExcept = false;
        if (userEnterNumber.length() != 3) {
            isEnterNumberExcept = true;
        }
        return isEnterNumberExcept;
    }
    public boolean isEnterNumberRepeat(String userEnterNumber) {
        boolean isEnterNumberExcept = false;
        if (userEnterNumber.charAt(0) == userEnterNumber.charAt(1) || userEnterNumber.charAt(1) == userEnterNumber.charAt(2)
                || userEnterNumber.charAt(0) == userEnterNumber.charAt(2)) {
            isEnterNumberExcept = true;
        }
        return isEnterNumberExcept;
    }
    public boolean hasEnterNumberNoNumber(String userEnterNumber) {
        boolean isEnterNumberExcept = false;
        List<Integer> OneToNine = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < 3; i++) {
            if (!OneToNine.contains(Character.getNumericValue(userEnterNumber.charAt(i)))) {
                isEnterNumberExcept = true;
            }
        }
        return isEnterNumberExcept;
    }
    public boolean isEnterNumberExcept(String userEnterNumber) {
        boolean isExcepted = false;
        if (enterNumberLengthExcept(userEnterNumber) || isEnterNumberRepeat(userEnterNumber) || hasEnterNumberNoNumber(userEnterNumber)) {
            isExcepted = true;
        }
        return isExcepted;
    }
    public void getEnterNumber(String userEnterNumber) {
        if (!isEnterNumberExcept(userEnterNumber)) {
            for (int i = 0; i < 3; i++) {
                enterNumber.add(Character.getNumericValue(userEnterNumber.charAt(i)));
            }
        }
        if (isEnterNumberExcept(userEnterNumber)) {
            throw new IllegalArgumentException("정확한 세 자리 숫자를 입력해주세요");
        }
    }
}
