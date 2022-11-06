package baseball;

import java.util.List;

public class Output {

    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String BALL_SPACE = "볼 ";
    private static final String STRIKE = "스트라이크";

    public void printStrikeBall(List<Integer> strikeBall) {
        if (strikeBall.get(0) == 0 && strikeBall.get(1) == 0) {
            System.out.println(NOTHING);
        }
        exceptNothing(strikeBall);
    }

    private void exceptNothing(List<Integer> strikeBall) {
        if (strikeBall.get(1) != 0 && strikeBall.get(0) == 0) {
            System.out.println(strikeBall.get(1) + BALL);
        } else if (strikeBall.get(1) == 0 && strikeBall.get(0) != 0) {
            System.out.println(strikeBall.get(0) + STRIKE);
        } else if (strikeBall.get(1) != 0 && strikeBall.get(0) != 0) {
            System.out.println(strikeBall.get(1) + BALL_SPACE + strikeBall.get(0) + STRIKE);
        }
    }
}
