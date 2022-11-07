package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class User {

    public void validateNumber(String numberString) {
        if(numberString.length()!=3) {
            throw new IllegalArgumentException("3자리를 입력하세요");
        }

        String pattern = "^[1-9]*$";

        if(!Pattern.matches(pattern, numberString)) {
            throw new IllegalArgumentException("1~9만 입력하세요");
        }

        String[] numberStringArray = numberString.split("");

        int nonDupplicateElementCnt = Arrays.stream(numberStringArray).distinct().toArray(String[]::new).length;

        if(nonDupplicateElementCnt!=numberStringArray.length) {
            throw new IllegalArgumentException("중복된 원소가 있습니다");
        }

    }

    public List<Integer> generateNumberList(String numberString) {

        List<Integer> numberList = new ArrayList<>();
        String[] numberStringArray = numberString.split("");

        for(String number : numberStringArray) {
            numberList.add(Integer.parseInt(number));
        }

        return numberList;
    }
}
