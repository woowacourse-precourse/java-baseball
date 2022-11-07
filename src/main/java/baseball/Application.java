package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.initGame();
    }

    /**
     * 게임 진행을 담당하는 함수
     */
    public void initGame() {
        GameStatus status = GameStatus.CONTINUE;
        do {
            if (isStopStatus(status)) {
                break;
            }
            if (isExceptionStatus(status)) {
                throw new IllegalArgumentException();
            }
            GameFormatter.gameStartMessage();
            String answer = initComputerAnswer();
            processComparing(answer);
            GameFormatter.gameEndMessage();
            status = setGameStatus(Console.readLine());
        } while (true);
    }

    /**
     * 게임 진행 상황을 제어하는 함수
     *
     * @param input
     * @return GameStatus
     */
    GameStatus setGameStatus(String input) {
        GameStatus status;
        switch (input) {
            case "1":
                status = GameStatus.CONTINUE;
                break;
            case "2":
                status = GameStatus.STOP;
                break;
            default:
                status = GameStatus.EXCEPTION;
                break;
        }
        return status;
    }

    /**
     * 상대방(컴퓨터)가 1부터 9까지 셔플한 결과 중 3개를 뽑아 문자열로 반환
     *
     * @return answer
     */
    String initComputerAnswer() {
        StringBuffer answer = new StringBuffer();
        // 1~9까지 숫자 중 shuffle 한 다음, 앞의 3개의 수를 반환
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        for (Integer uniqueNum : list) {
            answer.append(uniqueNum);
        }
        return answer.toString();
    }

    /**
     * 정답과 사용자 입력값을 비교하고 결과를 반환하는 함수
     *
     * @param answer
     */
    void processComparing(String answer) {
        do {
            GameFormatter.gameInputMessage();
            String player = Console.readLine();
            validateLength(player);
            validateNumericValue(player);
            validateUniqueNumber(player);
        } while (true);
    }

    boolean isStopStatus(GameStatus status) {
        return status.equals(GameStatus.STOP);
    }

    boolean isExceptionStatus(GameStatus status) {
        return status.equals(GameStatus.EXCEPTION);
    }

    void validateLength(String input) {
        if (input.length() == 0 || input.length() > 3) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * [1~9] 에 해당하는 숫자 데이터가 아닐 떄
     *
     * @param input
     */
    void validateNumericValue(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * Set의 특성을 이용해 중복 문자 발생시 예외 발생
     *
     * @param input
     */
    void validateUniqueNumber(String input) {
        Set<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            set.add(c);
        }
        if (set.size() != input.length()) {
            throw new IllegalArgumentException();
        }
    }
}
