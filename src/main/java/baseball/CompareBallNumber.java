package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CompareBallNumber {
    public HashMap<MatchBalls, Long> resultHashMap;
    public boolean isDone;
    CompareBallNumber() {
        this.resultHashMap = new HashMap<>();
        isDone = false;
    }

    public HashMap<MatchBalls, Long> checkMatchBalls(List<Integer> inputBallList, List<Integer> computerBallList) {
        long cntStrike = 0;
        long cntBall = 0;
        long cntNothing = 0;

       for(int i=0; i<inputBallList.size(); i++){
           if(Objects.equals(inputBallList.get(i), computerBallList.get(i))){
               cntStrike++;
           }
           else if(computerBallList.contains(inputBallList.get(i))){
               cntBall++;
           }

           else{
               resultHashMap.put(MatchBalls.낫싱, cntNothing);
           }
       }

        resultHashMap.put(MatchBalls.스트라이크, cntStrike);
        resultHashMap.put(MatchBalls.볼, cntBall);
        return resultHashMap;
    }

    public boolean is3Strike(){
        return resultHashMap.get(MatchBalls.스트라이크) == 3 || isDone;
    }
}
