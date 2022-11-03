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

    private boolean isNotNumber(String inputNumber) {

        for(int indexNumber=0; indexNumber<inputNumber.length(); indexNumber++){
            char ch = inputNumber.charAt(indexNumber);

            if(!Character.isDigit(ch) || ch == '0'){
                return true;
            }
        }

        return false;

    }
    



}
