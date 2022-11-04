package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    final static int INITE_GAME_START_VALUE = 1;
    final static int FLAG_RETRY_INT = 1;
    final static int MIN_RANDOM_VALUE = 1;
    final static int MAX_RANDOM_VALUE = 9;
    final static int MAX_NUMBERS_COUNT = 3;

    final static String MESSAGE_START = "숫자 야구 게임을 시작합니다.";
    final static String MESSAGE_REQUEST_INPUT = "숫자를 입력해주세요 : ";
    final static String MESSAGE_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final static String MESSAGE_RETRY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final static String FLAG_RETRY_STRING = "1";
    final static String FLAG_STOP_STRING = "2";

    public static void main(String[] args) {
        System.out.println(MESSAGE_START);

        int gameStart = INITE_GAME_START_VALUE;

        /* 프로그램 메인 구조, 게임 중단 플래그가 세워질 때 까지 반복, 예외 발생 시 프로그램 중단 */
        while(gameStart == FLAG_RETRY_INT) {
            try {
                gameStart = playBall();
            } catch(IllegalArgumentException exception) {
                exception.printStackTrace();
                return;
            }
        }
    }

    private static int playBall() {
        /* 컴퓨터 숫자 정하기 파트 */
        final List<Integer> COMPUTERS_NUMBERS = List.copyOf(setComputersNumbers());

        /* 게임 시퀀스 루프 */
//        int strike = INITE_STRIKE_COUNT;
//        while(strike < MAX_STRIKE_COUNT) {
//
//        }

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

    private static int validateRePlayOrStop(String playAgain) {
        if(!(playAgain.equals(FLAG_RETRY_STRING) || playAgain.equals(FLAG_STOP_STRING))) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(playAgain);
    }
}
