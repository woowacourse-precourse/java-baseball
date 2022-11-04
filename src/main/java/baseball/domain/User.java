package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class User {

    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    public ArrayList<Integer> userNumbers;

    public void inputUserNumbers() {
        System.out.print(INPUT_NUMBER);
        String numbers = Console.readLine();
        this.userNumbers = parseStringToInt(numbers);
        System.out.println();
    }

    public ArrayList<Integer> parseStringToInt(String numbers) {
        checkLength(numbers);
        ArrayList<Integer> inputNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            checkIsDigit(numbers.charAt(i));
            int number = charToInt(numbers.charAt(i));
            checkValidNumber(number);
            checkDuplicationNumber(inputNumbers, number);
            inputNumbers.add(number);
        }
        return inputNumbers;
    }


}
