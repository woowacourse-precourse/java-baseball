package baseball;

import java.util.List;
import java.util.Set;

public class Hint {

    private HintPair hintPair;
    private final static int NUMBER_LENGTH = 3;
    private final static String BALL = "볼";
    private final static String STRIKE = "스트라이크";
    private final static String NOT_THING = "낫싱";
    private final static String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public boolean isMatch(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (!computer.get(i).equals(user.get(i))) return false;
        }
        System.out.println(GAME_OVER_MESSAGE);
        return true;
    }

    public void getHint(List<Integer> computer, List<Integer> user, Set<Integer> usingComputer) {
        hintPair = new HintPair();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            increaseBallAndStrikeOfIndex(computer, user, i, usingComputer);
        }
        showHint();
    }

    private void increaseBallAndStrikeOfIndex(List<Integer> computer, List<Integer> user, int index, Set<Integer> usingComputer) {
        if (computer.get(index).equals(user.get(index))) {
            hintPair.increaseStrike();
        } else if (usingComputer.contains(user.get(index))) {
            hintPair.increaseBall();
        }
    }

    private void showHint() {
        if (hintPair.getCountBall() == 0 && hintPair.getCountStrike() == 0) {
            System.out.println(NOT_THING);
        } else if (hintPair.getCountBall() == 0 && hintPair.getCountStrike() != 0) {
            System.out.println(hintPair.getCountStrike() + STRIKE);
        } else if (hintPair.getCountBall() != 0 && hintPair.getCountStrike() == 0) {
            System.out.println(hintPair.getCountBall() + BALL);
        } else {
            System.out.println(hintPair.getCountBall() + BALL + " " + hintPair.getCountStrike() + STRIKE);
        }
    }
}
