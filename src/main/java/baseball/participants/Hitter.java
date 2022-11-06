package baseball.participants;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Hitter {
    public StrikeZone swingZone;

    public Hitter() {
    }

    public void swing() {
        List<Integer> swingList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            swingList.add(pickNumberInRange(1,9));
        }
        swingZone = new StrikeZone(swingList);
    }
}
