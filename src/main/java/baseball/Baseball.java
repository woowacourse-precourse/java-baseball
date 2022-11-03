package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Baseball {
    String userNumbers;
    int numberLength;
    List<Integer> computerNumber;

    Baseball() {
        this(3);
    }

    Baseball(int numberLength) {
        this.numberLength = numberLength;
    }

    private void setUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        userNumbers = Console.readLine();
        System.out.println();
    }

    private int checkStrike(int computerNumber, int userNumber, int strike) {
        if (computerNumber == userNumber) {
            return ++strike;
        }

        return strike;
    }
}
