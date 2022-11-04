package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    final static int INITE_GAME_START_VALUE = 0;
    final static int FLAG_RETRY_INT = 1;
    final static int MIN_RANDOM_VALUE = 1;
    final static int MAX_RANDOM_VALUE = 9;
    final static int MAX_NUMBERS_COUNT = 3;

    final static String MESSAGE_START = "숫자 야구 게임을 시작합니다.";

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
        int strike = INITE_STRIKE_COUNT;
        while(strike < MAX_STRIKE_COUNT) {

        }

        /* 게임 재시작 여부 확인 파트 */

        return /* gameStart 변수에 입력할 값 1 or 2 */;
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
}
