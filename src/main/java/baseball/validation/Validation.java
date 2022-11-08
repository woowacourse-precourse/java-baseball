package baseball.validation;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    private static final ArrayList<String> listOfNumbers = new ArrayList<>(List.of(new String[]{"1","2","3","4","5","6","7","8","9"}));
    private static final ArrayList<String> oneOrTwo = new ArrayList<>(List.of(new String[]{"1","2"}));

    public void validationNumbers(String[] numbers){
        isNotANumber(numbers);
        isThreeWord(numbers);
    }

    // 숫자인데 입력이 없거나 한자리수, 두자리수, 세자리 초과인 경우
    private static void isThreeWord(String[] numbers) {
        if(numbers.length != 3){
            throw new IllegalArgumentException("세자리 수를 정확하게 입력해주세요.");
        }
    }

    // 0이거나 숫자가 아니라면?
    private static void isNotANumber(String[] number) {
        for(String n : number){
            if(!listOfNumbers.contains(n)){
                throw new IllegalArgumentException("0과 숫자 이외의 문자를 입력하셨습니다.");
            }
        }
    }
}
