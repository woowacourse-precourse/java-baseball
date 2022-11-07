package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> selectNumbers() {
        List<Integer> result = new ArrayList<>();

        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }

        return result;
    }

    public static void validateUserNumbers(String input) throws IllegalArgumentException{
        if (input.length() != 3) {
            throw new IllegalArgumentException("세자리가 아닌 수를 입력하였습니다.");
        }else if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(2) == input.charAt(0)) {
            throw new IllegalArgumentException("중복된 수를 입력하였습니다.");
        }else if (!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(1)) || !Character.isDigit(input.charAt(2))) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하였습니다.");
        }
    }
}
