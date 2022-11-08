package baseball.io;

import java.util.List;

public class Output {

    public void printStrikeBall(List<Integer> strikeBall) {
        StringBuilder sb = new StringBuilder();
        if (strikeBall.get(0) == 0 && strikeBall.get(1) == 0) {
            sb.append(OutputMessage.NOTHING_MESSAGE.getMessage());
        }
        exceptNothing(strikeBall, sb);
        System.out.println(sb);
    }

    private static void exceptNothing(List<Integer> strikeBall, StringBuilder sb) {
        if (strikeBall.get(1) != 0 && strikeBall.get(0) == 0) {
            sb.append(strikeBall.get(1)).append(OutputMessage.BALL_MESSAGE.getMessage());
        } else if (strikeBall.get(1) == 0 && strikeBall.get(0) != 0) {
            sb.append(strikeBall.get(0)).append(OutputMessage.STRIKE_MESSAGE.getMessage());
        } else if (strikeBall.get(1) != 0 && strikeBall.get(0) != 0) {
            sb.append(strikeBall.get(1)).append(OutputMessage.BALL_SPACE_MESSAGE.getMessage()).append(strikeBall.get(0))
                    .append(OutputMessage.STRIKE_MESSAGE.getMessage());
        }
    }
}
