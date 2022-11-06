package baseball;

import java.util.List;

public class Result {
    public static Boolean getResult(List<Integer> balls, int[] userBalls){
        int strike=0;
        int ball=0;
        for(int i=0; i<balls.size(); i++){
            if (userBalls[i]==balls.get(i)){
                strike+=1;
            }
            else if(balls.contains(userBalls[i])){
                ball+=1;
            }
        }
        return strike == balls.size();
    }
}
