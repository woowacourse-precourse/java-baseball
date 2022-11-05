package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    public String getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public boolean isDigit(char digit) {
        return digit >= '1' && digit <= '9';
    }

    public boolean isNumber(String number) {
        boolean allDigit = true;
        int index = 0;
        while (allDigit && index < number.length()) {
            char digit = number.charAt(index);
            allDigit = isDigit(digit);
            index++;
        }
        return allDigit;
    }
}
