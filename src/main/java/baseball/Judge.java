package baseball;

import java.util.Collections;
import java.util.List;

public class Judge {

    public Integer countStrike(List<Integer> randomNumberList, List<Integer> userNumberList) {
        Integer strikeCnt=0;

        for(int i=0; i<randomNumberList.size(); i++) {
            if(randomNumberList.get(i) == userNumberList.get(i)) {
                strikeCnt++;
            }
        }

        return strikeCnt;
    }

    public Integer countBall(List<Integer> randomNumberList, List<Integer> userNumberList, Integer strike) {
        Integer ballCnt=0;

        for(int i=0; i<randomNumberList.size(); i++) {
            if(userNumberList.contains(randomNumberList.get(i))) {
                ballCnt++;
            }
        }

        ballCnt-=strike;

        return ballCnt;
    }
}
