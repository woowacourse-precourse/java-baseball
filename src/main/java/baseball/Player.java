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

    public boolean isThreeLetter(String number) {
        return number.length() == 3;
    }

    public boolean isAllDifferent(String number) {
        char first = number.charAt(0);
        char second = number.charAt(1);
        char third = number.charAt(2);
        if (first == second) {
            return false;
        }
        if (second == third) {
            return false;
        }
        return third != first;
    }

    public boolean isValidNumber(String number) {
        if (!isThreeLetter(number)) {
            return false;
        }
        if (!isNumber(number)) {
            return false;
        }
        return isAllDifferent(number);
    }

    public String getRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public boolean isOneLetter(String restart) {
        return restart.length() == 1;
    }

    public boolean isOneOrTwo(String restart) {
        char letter = restart.charAt(0);
        return letter == '1' || letter == '2';
    }

    public boolean isValidRestart(String restart) {
        if (!isOneLetter(restart)) {
            return false;
        }
        return isOneOrTwo(restart);
    }

    public static void isNotValid() {
        try {
            throw new IllegalArgumentException();
        }
        catch (Exception e) {
            System.exit(1);
        }
    }
}
