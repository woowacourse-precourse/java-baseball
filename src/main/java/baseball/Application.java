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

    public static int countBall(int numsOfEqualNumber, int strike) {
        return numsOfEqualNumber - strike;
    }

    public static boolean youWantMoreGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = readLine();
        if (choice.equals("1")) {
            return true;
        } else if (choice.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public static boolean round(List<Integer> computerNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNumber = setUserNumber();

        int numsOfEqualNumber = numsOfEqualNumber(computerNumber, userNumber);
        int Strike = countStrike(computerNumber, userNumber);
        int Ball = countBall(numsOfEqualNumber, Strike);

        if (Strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (Strike == 0 && Ball == 0) {
            System.out.println("낫싱");
        } else if (Strike == 0) {
            System.out.println(Ball + "볼");
        } else if (Ball == 0) {
            System.out.println(Strike + "스트라이크");
        } else {
            System.out.println(Ball + "볼 " + Strike + "스트라이크");
        }
        return false;
    }

    public static void baseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean doYouWantGame = true;
        while (doYouWantGame) {
            List<Integer> computerNumber = setComputerNumber();
            boolean correct = false;
            while (!correct) {
                correct = round(computerNumber);
            }
            doYouWantGame = youWantMoreGame();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
