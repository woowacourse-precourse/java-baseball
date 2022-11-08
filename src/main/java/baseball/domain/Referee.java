package baseball.domain;

import java.util.List;

public class Referee {
    public static final int INITIAL_VALUE = 0;
    public static final int MAX_STRIKE = 3;

    private int ball;
    private int strike;

    public void getHint(List<Integer> userNumber, List<Integer> computerNumber) {
        resetCount();
        getBallCount(userNumber, computerNumber);
        getStrikeCount(userNumber, computerNumber);
        ballStrikeCount();
    }

    private void hint(int ball, int strike) {

        if (ball != INITIAL_VALUE) {
            System.out.printf("%d볼 %d스트라이크%n", ball, strike);
        }

        if (ball == INITIAL_VALUE && strike != INITIAL_VALUE) {
            System.out.printf("%d스트라이크%n", strike);
        }

        if (ball == INITIAL_VALUE && strike == INITIAL_VALUE) {
            System.out.println("낫싱");
        }
    }

    private void ballStrikeCount() {
        ball -= strike;
        hint(ball, strike);
    }

    private void resetCount() {
        ball = INITIAL_VALUE;
        strike = INITIAL_VALUE;
    }

    private void getBallCount(List<Integer> userNumber, List<Integer> computerNumber) {

        for (Integer uNum : userNumber) {
            if (computerNumber.contains(uNum)) {
                ball++;
            }
        }
    }

    private void getStrikeCount(List<Integer> userNumber, List<Integer> computerNumber) {
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i).equals(computerNumber.get(i))) {
                strike++;
            }
        }
    }

    public boolean isThreeStrike() {
        if (strike == MAX_STRIKE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }

        return false;
    }
}
