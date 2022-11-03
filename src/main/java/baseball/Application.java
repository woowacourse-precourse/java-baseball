package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        playGame();
    }

    public static void playGame() {

        startGame();

        do {
            List<Integer> randomNumberList = new ArrayList<>();
            putInRandomNumber(randomNumberList);

            String numberString = putInNumber();

            if (! checkNumber(numberString)) {
                continue;
            }
            break;

        } while(true);
    }

    public static void startGame() {

        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void putInRandomNumber(List<Integer> randomNumberList) {

        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumberList.contains(randomNumber)) {

                randomNumberList.add(randomNumber);
            }
        }
    }

    public static String putInNumber() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static boolean checkNumber(String numberString) {

        try {

            if (! check(numberString)) throw new IllegalStateException();

            return true;


        } catch (IllegalStateException e) {

            return false;
        }

    }

    public static boolean check(String numberString) {

        if (! checkLength(numberString) || ! checkInteger(numberString) || ! checkDuplicateNumber(numberString)) {

            return false;
        }

        return true;
    }

    public static boolean checkLength(String numberString) {

        if (numberString.length() != 3) {

            return false;
        }

        return true;
    }

    public static boolean checkInteger(String numberString) {

        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) < 49 || numberString.charAt(i) > 57) {

                return false;
            }
        }

        return true;
    }

    public static boolean checkDuplicateNumber(String numberString) {

        if ((int) numberString.charAt(0) == (int) numberString.charAt(1)
                || (int) numberString.charAt(1) == (int) numberString.charAt(2)
                || (int) numberString.charAt(0) == (int) numberString.charAt(2)) {

            return false;
        }

        return true;
    }

}
