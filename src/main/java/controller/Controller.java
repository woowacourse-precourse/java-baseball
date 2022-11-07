package controller;

import java.util.HashMap;
import java.util.List;
import model.Computer;
import model.GamePlayer;
import view.Input;
import view.Print;

public class Controller {

    public static final char MAXIMUM_RANGE = '9';
    public static final char MINIMUM_RANGE = '1';
    public static final int DIGITS = 3;

    /**
     * 게임플레이어 클래스에 담을 서로 다른 숫자 값이 유효한지 검사한다.
     *
     * @param numbers 서로 다른 숫자
     * @return 유효할 경우 true, 아니라면 false
     */
    public static boolean validateNumbers(String numbers) {
        if (!isLengthCorrect(numbers)) {
            return false;
        }
        if (!isInRange(numbers)) {
            return false;
        }
        if (!differFromEachOther(numbers)) {
            return false;
        }
        return true;
    }

    private static boolean isLengthCorrect(String str) {
        if (str.length() != DIGITS) {
            return false;
        }
        return true;
    }

    private static boolean isInRange(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch < MINIMUM_RANGE || MAXIMUM_RANGE < ch) {
                return false;
            }
        }
        return true;
    }

    private static boolean differFromEachOther(String str) {
        for (int i = 1; i < str.length(); i++) {
            char frontLetter = str.charAt(i - 1);
            String backString = str.substring(i);
            if (existsCharacter(frontLetter, backString)) {
                return false;
            }
        }
        return true;
    }

    private static boolean existsCharacter(char findCharacter, String str) {
        for (int i = 0; i < str.length(); i++) {
            char characterInString = str.charAt(i);
            if (compareCharacters(findCharacter, characterInString) == 0) {
                return true;
            }
        }
        return false;
    }

    private static int compareCharacters(char ch1, char ch2) {
        return (int) (ch1 - ch2);
    }

    /**
     * 잘못된 입력이 들어올 경우 IllegalArgumentException을 발생시키고 종료한다.
     *
     * @param result false일 때만 발생시킨다. true라면 아무런 동작도 하지 않는다.
     */
    public static void handleException(boolean result) {
        if (!result) {
            throw new IllegalArgumentException("잘못된 값을 입력하여 종료합니다.");
        }
    }

    /**
     * 컴퓨터의 서로 다른 3자리수 랜덤값과 게임플레이어에게서 입력 받은 서로 다른 3자리수 비교한다.
     *
     * @return 일치하는 만큼 key: "strike", "ball"에 저장한다.
     */
    public static HashMap<String, Integer> compareTo(Computer computer, GamePlayer gamePlayer) {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("strike", 0);
        result.put("ball", 0);

        int[] source = gamePlayer.numbers;
        List<Integer> destination = computer.getRandomNumbers();
        boolean[] collection = computer.getCollection();
        for (int i = 0; i < source.length; i++) {
            Integer target = destination.get(i);
            int currentNumber = source[i];
            Integer currentStrike = result.get("strike");
            Integer currentBall = result.get("ball");

            if (target == currentNumber) {
                currentStrike++;
            } else if (collection[currentNumber - Computer.MINIMUM_NUMBER]) {
                currentBall++;
            }
            result.replace("strike", currentStrike);
            result.replace("ball", currentBall);
        }
        return result;
    }

    /**
     * 3스트라이크시 사용하는 함수, 입력을 받는데 "1"일 경우 재시작, "2"일 경우 종료한다. 잘못된 입력이 들어올 경우 IllegalArgumentException을 발생시키고 종료한다.
     *
     * @return 종료시 true, 재시작시 false;
     */
    public static boolean gameOver() {
        Print.gameOver();
        String power = Input.power();
        handleException(validatePower(power));
        if (power.equals("2")) {
            return true;
        }
        return false;
    }

    private static boolean validatePower(String power) {
        if (power.equals("1") || power.equals("2")) {
            return true;
        }
        return false;
    }
}
