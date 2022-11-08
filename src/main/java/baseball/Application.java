package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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
        // pickNumberInRange를 이용하는 함수를 호출해 문자열로 변환 후 반환
        for(Integer num : getRandomNumberList()){
            answer.append(num);
        }
        return answer.toString();
    }

    List<Integer> getRandomNumberList(){
        List<Integer> list = new ArrayList<>();
        while(list.size() < 3){
            int randNum = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(randNum)){
                list.add(randNum);
            }
        }
        return list;
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
            boolean hasHit = compareByRule(answer, player);

            if (hasHit) {
                break;
            }
        } while (true);
    }

    /**
     * 정답과 사용자 입력값에 대해 숫자 야구 규칙을 적용
     *
     * @param answer
     * @param player
     */
    boolean compareByRule(String answer, String player) {
        int strike = getStrike(answer, player);
        int ball = getBall(answer, player);
        boolean isHit = strike == answer.length();
        boolean isNothing = (strike + ball) == 0;
        boolean onlyStrikes = (ball == 0) && strike > 0;
        boolean onlyBalls = (strike == 0) && ball > 0;
        if (isHit) {
            GameFormatter.gameHitMessage(strike);
            return true;
        } else if (isNothing) {
            GameFormatter.gameNothingMessage();
        } else if (onlyStrikes) {
            GameFormatter.gameOnlyStrikeMessage(strike);
        } else if (onlyBalls) {
            GameFormatter.gameOnlyBallMessage(ball);
        } else {
            GameFormatter.gameBothBallAndStrikeMessage(ball, strike);
        }
        return false;
    }

    int getStrike(String answer, String player) {
        int result = 0;
        for (int i = 0; i < player.length(); i++) {
            if (player.charAt(i) == answer.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    int getBall(String answer, String player) {
        int result = 0;
        for (int i = 0; i < player.length(); i++) {
            boolean diffValue = player.charAt(i) != answer.charAt(i);
            boolean containsValue = answer.contains(String.valueOf(player.charAt(i)));
            if (diffValue && containsValue) {
                result++;
            }
        }
        return result;
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
