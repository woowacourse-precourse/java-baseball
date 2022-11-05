package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnterNumber {

    private List<Integer> enterNumber;
    public EnterNumber() {
        enterNumber = new ArrayList<>(Arrays.asList(0, 0, 0));
    }
    public List<Integer> getEnterNumber() {
        return this.enterNumber;
    }
    public boolean exceptLength(String userEnterNumber) {
        boolean isEnterNumberExcept = false;
        if (userEnterNumber.length() != 3) {
            isEnterNumberExcept = true;
        }
        return isEnterNumberExcept;
    }
    public boolean repeatNumber(String userEnterNumber) {
        boolean isEnterNumberExcept = false;
        if (userEnterNumber.charAt(0) == userEnterNumber.charAt(1) || userEnterNumber.charAt(1) == userEnterNumber.charAt(2)
                || userEnterNumber.charAt(0) == userEnterNumber.charAt(2)) {
            isEnterNumberExcept = true;
        }
        return isEnterNumberExcept;
    }
    public boolean hasNoNumber(String userEnterNumber) {
        boolean isEnterNumberExcept = false;
        List<Integer> OneToNine = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < 3; i++) {
            if (!OneToNine.contains(Character.getNumericValue(userEnterNumber.charAt(i)))) {
                isEnterNumberExcept = true;
            }
        }
        return isEnterNumberExcept;
    }
    public boolean exceptNumber(String userEnterNumber) {
        boolean isExcepted = false;
        if (exceptLength(userEnterNumber) || repeatNumber(userEnterNumber) || hasNoNumber(userEnterNumber)) {
            isExcepted = true;
        }
        return isExcepted;
    }
    public void getList(String userEnterNumber) {
        if (!exceptNumber(userEnterNumber)) {
            for (int i = 0; i < 3; i++) {
                enterNumber.set(i, Character.getNumericValue(userEnterNumber.charAt(i)));

                // TODO: 테스트 완료되면 지울 것
                System.out.println(userEnterNumber.charAt(i));
            }
        }
        if (exceptNumber(userEnterNumber)) {
            throw new IllegalArgumentException("정확한 세 자리 숫자를 입력해주세요");
        }
    }
}
