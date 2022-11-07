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
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static Integer inputTotalNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInputNumber = Console.readLine();
        checkUserInput(userInputNumber);
        return Integer.valueOf(userInputNumber);
    }


    private static boolean inputPlayGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if (!checkInputPlayGame(userInput)) {
            throw new IllegalArgumentException();
        }
        return userInput.equals("1");
    }

    private static void checkOneDigitNumberCount(Integer number, Integer index, List<Integer> secretNumber, List<Integer> hitCount) {
        if (secretNumber.get(index.intValue()).equals(number)) {
            hitCount.set(0, hitCount.get(0)+1);
        } else if (secretNumber.contains(number)) {
            hitCount.set(1, hitCount.get(1)+1);
        }
    }


    private static void checkTotalNumberCount(Integer totalNumber, List<Integer> secretNumber, List<Integer> hitCount) {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            Integer number = Integer.parseInt(String.valueOf(totalNumber.toString().charAt(i)));
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
        Integer countOfStrike = hitCount.get(0);
        Integer countOfBall = hitCount.get(1);
        if (countOfStrike.equals(0) && countOfBall.equals(0)) {
            System.out.println("낫싱");
        } else if (countOfStrike.equals(0)) {
            System.out.println(countOfBall + "볼");
        } else if (countOfBall.equals(0)) {
            System.out.println(countOfStrike + "스트라이크");
        } else {
            System.out.println(countOfBall + "볼 " + countOfStrike + "스트라이크");
        }
    }

    private static boolean checkWin(List<Integer> hitCount) {
        return hitCount.get(0).equals(NUMBER_SIZE);
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

    private static boolean checkUserInputLength(String userInputNumber) {
        return NUMBER_SIZE.equals(userInputNumber.length());
    }

    private static boolean checkUserInputContainZero(String userInputNumber) {
        return userInputNumber.contains("0");
    }

    private static boolean checkUserInputNumber(String userInputNumber) {
        try {
            int numberValue = Integer.parseInt(userInputNumber);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private static boolean checkUserInputDuplicateNumber(String userInputNumber) {
        int distinctCount = (int) Arrays.stream(userInputNumber.split("")).distinct().count();
        return userInputNumber.length() == distinctCount;
    }

    private static boolean checkInputPlayGame(String userInput) {
        return userInput.equals("1") || userInput.equals("2");
    }


}
