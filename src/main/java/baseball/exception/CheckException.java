package baseball.exception;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CheckException {

    public void validateInputLength(String[] inputArray){
        if(inputArray.length!=3){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
        }
    }

    public void validateInputNum(String[] inputArray){
        StringBuilder sb = new StringBuilder();
        for(String str : inputArray) {
            sb.append(str);
        }
        String inputString = sb.toString();
        System.out.println(inputString);
        String pattern = "^[1-9]*$";
        boolean match = Pattern.matches(pattern, inputString);
        if(match==false) {
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
    }

    public void validateInputDistinct(String[] inputArray){
        if(Arrays.stream(inputArray).distinct().count()!=inputArray.length){
            throw new IllegalArgumentException("숫자가 중복되지 않게 입력해주세요");
        }
    }
}
