package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private static final Integer NUMBER_SIZE = 3;

    public static void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            play();
        } while (inputPlayGame());
    }

    private static void play() {
        List<Integer> hitCount;
        List<Integer> secretNumber = createSecretNumber();
        do {
            hitCount = initHitCount();
            Integer totalNumber = inputTotalNumber();
            checkTotalNumberCount(totalNumber, secretNumber, hitCount);
            showHitCount(hitCount);
        } while(!checkWin(hitCount));
        System.out.println("3대의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static Integer inputTotalNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInputNumber = Console.readLine();
        checkUserInput(userInputNumber);
        return Integer.valueOf(userInputNumber);
    }


    private static boolean inputPlayGame() {
        return true;
    }

    private static void checkOneDigitNumberCount(Integer number, Integer index, List<Integer> secretNumber, List<Integer> hitCount) {
        if (secretNumber.get(index.intValue()).equals(number)) {
            hitCount.set(0, hitCount.get(0)+1);
        } else if (secretNumber.contains(number)) {
            System.out.println(index + " " + number);
            hitCount.set(1, hitCount.get(1)+1);
        }
    }


    private static void checkTotalNumberCount(Integer totalNumber, List<Integer> secretNumber, List<Integer> hitCount) {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            Integer number = Integer.valueOf(totalNumber.toString().charAt(i));
            System.out.println(number);
            checkOneDigitNumberCount(number, i, secretNumber, hitCount);
        }
    }

    private static List<Integer> initHitCount() {
        List<Integer> hitCount = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            hitCount.add(0);
        }
        return hitCount;
    }

    private static void showHitCount(List<Integer> hitCount) {

    }

    private static boolean checkWin(List<Integer> hitCount) {
        return true;
    }

    private static List<Integer> createSecretNumber() {
        List<Integer> secretNumber = new ArrayList<>();
        while (secretNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!secretNumber.contains(randomNumber)) {
                secretNumber.add(randomNumber);
            }
        }
        return secretNumber;
    }

    private static void checkUserInput(String userInputNumber){
        if (!checkUserInputLength(userInputNumber)) {
            throw new IllegalArgumentException();
        } else if (checkUserInputContainZero(userInputNumber)){
            throw new IllegalArgumentException();
        } else if (!checkUserInputNumber(userInputNumber)) {
            throw new IllegalArgumentException();
        } else if (!checkUserInputDuplicateNumber(userInputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkUserInputLength(String userInputNumber) {
        return NUMBER_SIZE.equals(userInputNumber.length());
    }

    public static boolean checkUserInputContainZero(String userInputNumber) {
        return userInputNumber.contains("0");
    }

    public static boolean checkUserInputNumber(String userInputNumber) {
        try {
            int numberValue = Integer.parseInt(userInputNumber);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean checkUserInputDuplicateNumber(String userInputNumber) {
        int distinctCount = (int) Arrays.stream(userInputNumber.split("")).distinct().count();
        return userInputNumber.length() == distinctCount;
    }
}
