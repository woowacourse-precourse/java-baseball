package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        System.out.print("숫자를 입력해 주세요 : ");

    }
}


class UserInput {
    public static int request() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}

class InputNumber {
    int inputNumber = 0;

    InputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
        validDigits();
    }

    private void validDigits() {
        if (inputNumber > 999 || inputNumber < 111) {
            throw new IllegalArgumentException();
        }
    }
}

class BaseballNumber {
    private final int[] baseballNumber = new int[3];

    BaseballNumber(int baseballNumber) {
        divideDigits(baseballNumber);
        validation();
    }

    private void divideDigits(int baseballNumber) {
        String tmp = Integer.toString(baseballNumber);
        String[] stringDigits = tmp.split("");

        for (int index = 0; index < stringDigits.length; index++) {
            this.baseballNumber[index] = Integer.parseInt(stringDigits[index]);
        }
    }

    private void validation() {
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

