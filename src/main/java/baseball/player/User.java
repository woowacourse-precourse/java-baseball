package baseball.player;

import java.util.List;

public class User {

    private List<Integer> userNumberList;

    User(String inputNumber) {
        this.userNumberList = generateNumberList(inputNumber);
    }

    private List<Integer> generateNumberList(String inputNumber) {

        boolean exceptionCheck = false;

        if (isNotNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }

        List<Integer> numberList = changeStringToInteger(inputNumber);

        if (isNotThreeLength(numberList) || isDuplication(numberList)) {
            throw new IllegalArgumentException();
        }

        return numberList;

    }


}
