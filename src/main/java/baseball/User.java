package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    public List<Integer> generateNumberList(String numberString) throws IllegalArgumentException {
        if(numberString.length()!=3) {
            throw new IllegalArgumentException("3자리를 입력하세요");
        }

        List<Integer> numberList = new ArrayList<>();
        String[] numberStringArray = numberString.split("");

        for(String number : numberStringArray) {
            try {
                numberList.add(Integer.parseInt(number));
            }catch (IllegalArgumentException illegalArgumentException) {
                throw illegalArgumentException;
            }
        }

        int nonDupplicateElementCnt = Long.valueOf(numberList.stream().distinct().count()).intValue();

        if(nonDupplicateElementCnt!=numberList.size()) {
            throw new IllegalArgumentException("중복된 원소 입력");
        }

        return numberList;
    }
}
