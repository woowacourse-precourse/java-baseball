package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {

        System.out.print("숫자를 입력해 주세요 : ");
        System.out.println(UserInput.request());


    }
}


class UserInput {
    private static String readLine = "";
    public static String request() {
        readLine = Console.readLine();
        validLength();
        isNumber();

        return readLine;
    }

    private static void validLength() {
        if (readLine.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void isNumber() {
        Integer.parseInt(readLine);
    }
}

class BaseballNumber {
    private final int[] baseballNumber = new int[3];

    BaseballNumber(int baseballNumber) {
        divideDigits(baseballNumber);
        NumberValidation();
    }

    private void divideDigits(int baseballNumber) {
        String numberToString = Integer.toString(baseballNumber);
        String[] eachDigits = numberToString.split("");

        for (int index = 0; index < eachDigits.length; index++) {
            this.baseballNumber[index] = Integer.parseInt(eachDigits[index]);
        }
    }

    private void NumberValidation() {
        for (int index = 0; index < baseballNumber.length; index++) {
            validRange(baseballNumber[index]);
            validDuplication(baseballNumber[index], index);
        }
    }

    private void validRange(int eachNumber) {
        if (eachNumber == 0) {
            throw new IllegalArgumentException();
        }
    }
    private void validDuplication(int eachNumber, int index) {
        for (int i = 0; i < baseballNumber.length; i++) {
            if(index != i || eachNumber == baseballNumber[i]) {
                throw new IllegalArgumentException();
            }
        }
    }


    // 포함확인 함수
    // 위치확인 함수

}