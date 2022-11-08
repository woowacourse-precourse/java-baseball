package baseball.participants;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

/**
 * 숫자 야구 게임을 위한 숫자 세자리를 세팅합니다.
 */
public class Hitter {
    public StrikeZone swingZone;

    public Hitter() {
    }

    public void swing() {
        List<Integer> swingList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            swingList.add(pickNumberInRange(1, 9));
        }
        swingZone = new StrikeZone(swingList);
    }
}
