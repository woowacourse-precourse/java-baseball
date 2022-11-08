package baseball.io;

import java.util.List;

public class Output {

    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String BALL_SPACE = "볼 ";
    private static final String STRIKE = "스트라이크";

    public void printStrikeBall(List<Integer> strikeBall) {
        StringBuilder sb = new StringBuilder();
        if (strikeBall.get(0) == 0 && strikeBall.get(1) == 0) {
            sb.append(NOTHING);
        }
        exceptNothing(strikeBall, sb);
        System.out.println(sb);
    }

    private static void exceptNothing(List<Integer> strikeBall, StringBuilder sb) {
        if (strikeBall.get(1) != 0 && strikeBall.get(0) == 0) {
            sb.append(strikeBall.get(1)).append(BALL);
        } else if (strikeBall.get(1) == 0 && strikeBall.get(0) != 0) {
            sb.append(strikeBall.get(0)).append(STRIKE);
        } else if (strikeBall.get(1) != 0 && strikeBall.get(0) != 0) {
            sb.append(strikeBall.get(1)).append(BALL_SPACE).append(strikeBall.get(0)).append(STRIKE);
        }
    }
}
