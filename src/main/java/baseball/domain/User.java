package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private static String ISDIGIT_EXCEPTION = "숫자가 아닙니다.";
    private static String DUPLICATION_EXCEPTION = "중복된 숫자가 존재합니다.";
    public ArrayList<Integer> userNumbers;

    public void getUserNumbers() {
        String numbers = Console.readLine();
        this.userNumbers = parseStringToInt(numbers);
    }

    public ArrayList<Integer> parseStringToInt(String numbers) {
        ArrayList<Integer> inputNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            inputNumbers.add(Integer.parseInt(String.valueOf(numbers.charAt(i))));
        }
        return inputNumbers;
    }

    public void checkIsDigit(char number) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException(ISDIGIT_EXCEPTION);
        }
    }

    public void checkDuplicationNumber(ArrayList<Integer> numbers,int number){
        if(numbers.contains(number)){
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION);
        }
    }

}
