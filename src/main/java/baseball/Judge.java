package baseball;

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

    public Integer countBall(List<Integer> randomNumberList, List<Integer> userNumberList) {
        Integer ballCnt=0;

        for(int i=0; i<randomNumberList.size(); i++) {
            for(int j=0; j<userNumberList.size(); j++) {
                if(i==j) {
                    continue;
                }

                if(randomNumberList.get(i)==userNumberList.get(j)) {
                    ballCnt++;
                }
            }
        }

        return ballCnt;
    }
}
