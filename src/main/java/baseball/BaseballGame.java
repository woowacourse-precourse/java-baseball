package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public List<Integer> stringToIntegerList(String inputNumber) {  // 입력 값을 List<Integer>로
        List<Integer> number = new ArrayList<>();

        for (int digit = 0; digit < inputNumber.length(); digit++) {
            number.add(Integer.parseInt(String.valueOf(inputNumber.charAt(digit))));
        }
        return number;
    }
}
