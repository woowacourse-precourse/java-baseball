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

    public static List<Integer> addToList(String input) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            result.add(Character.getNumericValue(input.charAt(i)));
        }

        return result;
    }

    public static List<Integer> countCount(List<Integer> computer, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        int numOfStrike = 0;
        int numOfBall = 0;
        int numOfNothing = 0;

        for (int num : player) {
            if (!computer.contains(num)) {
                numOfNothing++;
            }else {
                if (player.indexOf(num) == computer.indexOf(num)) {
                    numOfStrike++;
                }else {
                    numOfBall++;
                }
            }
        }

        result.add(numOfStrike);
        result.add(numOfBall);
        result.add(numOfNothing);

        return result;
    }
}
