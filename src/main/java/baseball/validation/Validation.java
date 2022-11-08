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

    // 1과 2 이외의 숫자가 입력되었는지 확인
    public int validationRestartOrShutDown(String answer) {
        if(!oneOrTwo.contains(answer)){
            throw new IllegalArgumentException("1(시작) 또는 2(종료) 가 제대로 입력이 되었는지 확인해주세요.");
        }
        return Integer.parseInt(answer);
    }
}
