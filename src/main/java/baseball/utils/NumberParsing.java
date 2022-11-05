package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberParsing {

    public static boolean isDuplication(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public static List<Integer> changeStringToIntegers(String inputNumbers) {

        List<Integer> numbers = new ArrayList<>();

        for (int index = 0; index < inputNumbers.length(); index++) {

            String stringNumber = String.valueOf(inputNumbers.charAt(index));
            int integerNumber = Integer.parseInt(stringNumber);

            numbers.add(integerNumber);

        }

        return numbers;

    }

    //TODO : isRangeNumber로 수정
    public static boolean isNonZeroNumber(String inputNumbers) {

        for (int index = 0; index < inputNumbers.length(); index++) {

            char ch = inputNumbers.charAt(index);

            if (!Character.isDigit(ch) || ch == '0') {
                return false;
            }
        }

        return true;

    }

    
    //TODO : createRandomNumbersInRange로 수정
    public static List<Integer> createRandomNumbers(List<Integer> numbers, int count, int start, int end) {

        numbers.clear();

        for (; numbers.size() < count; ) {
            int randomNumber = Randoms.pickNumberInRange(start, end);
            numbers.add(randomNumber);
        }

        return numbers;

    }


    public static boolean isEqualToSetCount(List<Integer> numbers,int setCount) {
        return numbers.size() == setCount;
    }


    public static boolean hasNumber(List<Integer> numbers, int number) {

        for (int index = 0; index < numbers.size(); index++) {
            if (number == numbers.get(index)) {
                return true;
            }
        }

        return false;

    }

    public static boolean isSameNumber(int numberA,int numberB){
        return numberA == numberB;
    }



}
