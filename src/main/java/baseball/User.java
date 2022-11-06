package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static void getUserInput(List<Integer> computerNumber){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        List<Integer> inputNumber = checkTheNumber(input);

        Judge.checkTheResult(inputNumber, computerNumber);
    }

    public static List<Integer> checkTheNumber(String input) {
        boolean isWrongInput = false;
        int number = InputException.changeStrToInt(input);
        List<Integer> numArr = changeIntToList(number);

        if (InputException.isOverlap(numArr)
                || InputException.isNotSizeThree(numArr)
                || InputException.hasZero(numArr)) {
            isWrongInput = true;
        }

        if (isWrongInput == true) {
            throw new IllegalArgumentException("잘못된 입력입니다. 프로그램을 종료합니다.");
        }

        return numArr;
    }

    public static List<Integer> changeIntToList(int number) {
        List<Integer> numArr = new ArrayList<Integer>();

        while (number > 0) {
            numArr.add(0, number % 10);
            number /= 10;
        }

        return numArr;
    }
}
