package baseball.gameRule;

import baseball.GameFormatter;
import baseball.gameRule.GameRule;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class GameRuleDetail implements GameRule {
    /**
     * 정답과 사용자 입력값을 비교하고 결과를 반환하는 함수
     *
     * @param answer
     */
    @Override
    public void playByGameRule(String answer) {
        do {
            GameFormatter.gameInputMessage();
            String player = Console.readLine();
            validateLength(player);
            validateNumericValue(player);
            validateUniqueNumber(player);
            boolean hasHit = isStopCondition(answer, player);

            if (hasHit) {
                break;
            }
        } while (true);
    }

    @Override
    public boolean isStopCondition(String answer, String player) {
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
