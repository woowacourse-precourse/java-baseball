package baseball;

import java.util.List;

public class BallOrStrike {

    public int ballCount(List<String> ComputerNumber, List<String> userNumber) {
        int ballCount = 0;
        for (int ballLoop = 0; ballLoop < 3; ballLoop++) {
            if (!(ComputerNumber.get(ballLoop).equals(userNumber.get(ballLoop))) &&
                    ComputerNumber.contains(userNumber.get(ballLoop))) {
                ballCount++;
            }
        }
        return ballCount;
    }


    public int Cnt_Strike(List<String> ComputerNumber, List<String> userNumber) {
        int strikeCount = 0;
        for (int Loop = 0; Loop < 3; Loop++) {
            if (ComputerNumber.get(Loop).equals(userNumber.get(Loop))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

}