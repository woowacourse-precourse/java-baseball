package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    final static int ZERO = 0;
    final static int MIN_RANDOM_VALUE = 1;
    final static int MAX_RANDOM_VALUE = 9;
    final static int MIN_PATTERN_VALUE = 1;
    final static int MAX_PATTERN_VALUE = 9;
    final static int MAX_NUMBERS_COUNT = 3;
    final static int INIT_STRIKE_COUNT = 0;
    final static int MAX_STRIKE_COUNT = 3;

    final static String INIT_GAME_START_VALUE = "1";
    final static String MESSAGE_START = "숫자 야구 게임을 시작합니다.";
    final static String MESSAGE_REQUEST_INPUT = "숫자를 입력해주세요 : ";
    final static String MESSAGE_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final static String MESSAGE_RETRY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final static String FLAG_RETRY_STRING = "1";
    final static String FLAG_STOP_STRING = "2";
    final static String PATTERN = "^[" + MIN_PATTERN_VALUE +
                                    "-" + MAX_PATTERN_VALUE +
                                    "]{" + MAX_NUMBERS_COUNT + "}?$";

    public static void main(String[] args) {
        System.out.println(MESSAGE_START);

        String gameStart = INIT_GAME_START_VALUE;

        /* 프로그램 메인 구조, 게임 중단 플래그가 세워질 때 까지 반복, 예외 발생 시 프로그램 중단 */
        while(gameStart.equals(FLAG_RETRY_STRING)) {
            try {
                gameStart = playBall();
            } catch(IllegalArgumentException exception) {
                exception.printStackTrace();
                return;
            }
        }
    }

    private static String playBall() {
        /* 컴퓨터 숫자 정하기 파트 */
        final List<Integer> COMPUTERS_NUMBERS = List.copyOf(setComputersNumbers());

        /* 게임 시퀀스 루프 */
        int strike = INIT_STRIKE_COUNT;
        while(strike < MAX_STRIKE_COUNT) {
            String userInputNumbers = inputUserNumbers();
            validateInputPattern(userInputNumbers);
            final List<Integer> USERS_NUMBERS = List.copyOf(validateDuplication(userInputNumbers));

            strike = compareNumbers(USERS_NUMBERS, COMPUTERS_NUMBERS);
        }

        /* 게임 재시작 여부 확인 파트 */
        System.out.println(MESSAGE_GAME_OVER);
        System.out.println(MESSAGE_RETRY);
        String playAgain = checkRePlay();

        return validateRePlayOrStop(playAgain);
    }

    private static List<Integer> setComputersNumbers() {
        List<Integer> computersNumbers = new ArrayList<>(MAX_NUMBERS_COUNT);

        while(computersNumbers.size() < MAX_NUMBERS_COUNT) {
            final int RANDOM_NUMBER = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);

            if(!computersNumbers.contains(RANDOM_NUMBER)) {
                computersNumbers.add(RANDOM_NUMBER);
            }
        }

        return computersNumbers;
    }

    private static String checkRePlay() {
        System.out.println(MESSAGE_REQUEST_INPUT);
        return Console.readLine();
    }

    private static String validateRePlayOrStop(String playAgain) {
        if(!(playAgain.equals(FLAG_RETRY_STRING) || playAgain.equals(FLAG_STOP_STRING))) {
            throw new IllegalArgumentException();
        }

        return playAgain;
    }

    private static String inputUserNumbers() {
        System.out.print(MESSAGE_REQUEST_INPUT);
        return Console.readLine();
    }

    private static void validateInputPattern(String userInputNumbers) {
        if(!Pattern.matches(PATTERN, userInputNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> validateDuplication(String userInputNumbers) {
        List<Integer> duplicationTestList = new ArrayList<>(MAX_NUMBERS_COUNT);

        for(int indexNumber = ZERO; indexNumber < MAX_NUMBERS_COUNT; indexNumber++) {
            char charAtIndex = userInputNumbers.charAt(indexNumber);
            int intIndex = Character.getNumericValue(charAtIndex);

            if(duplicationTestList.contains(intIndex)) {
                throw new IllegalArgumentException();
            }

            duplicationTestList.add(intIndex);
        }

        return duplicationTestList;
    }
}
