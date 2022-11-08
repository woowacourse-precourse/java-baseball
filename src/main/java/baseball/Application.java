package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> setComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public static boolean isNumeric(String s) {
        return s.chars().allMatch(Character::isDigit);
    }

    public static List<Integer> convertStringToList(String s) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(Character.getNumericValue(s.charAt(i)));
        }
        return list;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
