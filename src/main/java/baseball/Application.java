package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

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

    public static boolean isItWrongNumber(List<Integer> userStringNumber) {
        int numbersOfUniqueNumber = new HashSet<>(userStringNumber).size();
        return (userStringNumber.size() != 3) || (numbersOfUniqueNumber != 3);
    }

    public static List<Integer> setUserNumber() {
        String tempNumber = readLine();
        List<Integer> userNumber = new ArrayList<>();

        if (!isNumeric(tempNumber)) {
            throw new IllegalArgumentException();
        }

        userNumber = convertStringToList(tempNumber);
        if (isItWrongNumber(userNumber)) {
            throw new IllegalArgumentException();
        }
        return userNumber;
    }

    public static int numsOfEqualNumber(List<Integer> computerNumber, List<Integer> userNumber) { // not countBall, not countStrike
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.contains(userNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static int countStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
