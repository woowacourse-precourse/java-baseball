package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    List userNumList = new ArrayList();

    public void InputNum() {
        String number = Console.readLine();
        isValid(number);
    }

    public void isValid(String num) {
        isNum(num);
        isThree(num);
        isNoZero(num);
        isNoDup(num);
    }

    public void isNum(String num) {
        for (char c : num.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
        }
    }

    public void isThree(String num) {
        if (num.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자가 아닙니다.");
        }
    }

    public void isNoZero(String num) {
        for (char c : num.toCharArray()) {
            if (c == '0') {
                throw new IllegalArgumentException("0은 입력할 수 없습니다.");
            }
        }
    }

    public void isNoDup(String num) {
        Set checkDup = new HashSet();
        for (char c : num.toCharArray()) {
            checkDup.add(c);
        }
        if (checkDup.size() != 3) {
            throw new IllegalArgumentException("중복된 수가 입력되었습니다.");
        }
    }
}
