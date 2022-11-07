package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class User {
    List userNumList = new ArrayList();

    public void inputNum() {
        String number = Console.readLine();
        isValid(number);
        userNumList = converToList(number);
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

    public List converToList(String num) {
        int intNum = Integer.parseInt(num);
        List list = new ArrayList();
        for (int idx = 0; idx < 3; idx++) {
            list.add(intNum % 10);
            intNum /= 10;
        }
        Collections.reverse(list);
        return list;
    }

    public int inputPlayAgain() {
        String answer = Console.readLine();
        if (Integer.parseInt(answer) != 1 && Integer.parseInt(answer) != 2) {
            throw new IllegalArgumentException("적절한 번호가 아닙니다.");
        }
        return Integer.parseInt(answer);
    }

    public List getUserNumList() {
        return userNumList;
    }
}
