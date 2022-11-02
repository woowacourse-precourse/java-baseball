package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static List<Integer> generateNumber(){
        List<Integer> num = new ArrayList<>();
        while (num.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!num.contains(randomNumber)) {
                num.add(randomNumber);
            }
        }
        return num;
    }
    public static void checkInput(String s){
        if (s.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        List<Integer> digits = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int digit = 0; digit < s.length(); digit++){
            if (!digits.contains(Character.getNumericValue(s.charAt(digit)))){
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String test = "123";
        checkInput(test);
    }
}
