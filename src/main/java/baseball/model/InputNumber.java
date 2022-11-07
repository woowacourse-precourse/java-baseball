package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputNumber {

    public static List<Integer> getValidNumberList() {
        String input = getPlayerInput();
        validateInputSize(input);
        validateDigitRange(input);

        List<Integer> inputList = stringToList(input);
        validateUniqueNumberList(inputList);
        return inputList;
    }

    public static String getPlayerInput() {
        return Console.readLine();
    }

    public static void printInputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private static List<Integer> stringToList(String input) {
        List<Integer> inputList = new ArrayList<>();
        String[] splitInput = input.split("");
        for (int i = 0; i < input.length(); i++) {
            inputList.add(Integer.valueOf(splitInput[i]));
        }
        return inputList;
    }

    private static void validateUniqueNumberList(List<Integer> numberList) {
        for (int i = 0; i < numberList.size(); i++) {
            validateUniqueNumber(numberList, i);
        }
    }

    private static void validateUniqueNumber(List<Integer> numberlist, int numberIndex) {
        for (int i = 0; i < numberlist.size(); i++) {
            if (numberIndex == i) {
                continue;
            }
            if (numberlist.get(numberIndex) == numberlist.get(i)) {
                throw new IllegalArgumentException("number is cannot duplicate.");
            }
        }
    }

    private static void validateInputSize(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("input has to be 3 length.");
        }
    }

    private static void validateDigitRange(String input) {
        if (!Pattern.matches("^[1-9]*$", input)) {
            throw new IllegalArgumentException("digit range is a number of from 1 to 9.");
        }
    }

//    public static void main(String[] args) {
//        printInputNumberMessage();
//        try {
//            System.out.println(getValidNumberInput());
//        }
//        catch (IllegalArgumentException e){
//            //e.printStackTrace();
//            System.out.println("message: "+e.getMessage());
//        }
//    }
}
