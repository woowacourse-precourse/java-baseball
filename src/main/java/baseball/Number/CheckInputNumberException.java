package baseball.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CheckInputNumberException {


    public void checkException(String number) {
        try {
            lengthException(number);
            duplicateException(number);
            notRangeNumberException(number);
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void notRangeNumberException(String number) throws Exception{
        if (!Pattern.matches("^[1-9]*$", number)) {
            throw new Exception("0과 문자는 입력하지마세요");
        }
    }

    private void lengthException(String number) throws Exception {
        if (number.length() > 3 || number.length() < 3) {
            throw new Exception("3자리 숫자를 입력해주세요");
        }
    }

    private void duplicateException(String number) throws Exception{
        List<Character> tmpNumbers = new ArrayList<>();

        for (int digit = 0; digit < number.length(); digit++) {
            if (!tmpNumbers.contains(number.charAt(digit))) {
                tmpNumbers.add(number.charAt(digit));
            }
            else if (tmpNumbers.contains(number.charAt(digit))) {
                throw new Exception("중복숫자를 입력하지마세요");
            }
        }
    }

}