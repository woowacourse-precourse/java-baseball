package baseball.utils.validation;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    public String validateClientNumbers(String clientNumbers) {
        int number;
        try {
            number = Integer.parseInt(clientNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        if(number > 999 || number < 100) {
            throw new IllegalArgumentException("세자리 숫자만 입력 가능합니다.");
        }

        List<Integer> digitNumbers = new ArrayList<>();
        String[] clientNumberArr = clientNumbers.split("");

        for(String strNumbers : clientNumberArr) {
            digitNumbers.add(Integer.parseInt(strNumbers));
        }

        if(digitNumbers.contains(0)) {
            throw new IllegalArgumentException("각 자릿수는 1-9 사이입니다.");
        }
        return clientNumbers;

    }

}
