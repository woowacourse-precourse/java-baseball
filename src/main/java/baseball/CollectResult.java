package baseball;

import java.util.ArrayList;
import java.util.List;

public class CollectResult {

    public static List<Integer> compareUserComputer(List<Integer> user, List<Integer> computer){

        List<Integer> baseballScore = new ArrayList<>();
        int strike = 0;
        int ball = 0;

        for(int i = 0; i<user.size(); i++){
            int userNum = user.get(i);
            int compareNum = computer.indexOf(userNum);

            if(compareNum == -1){
                continue;
            }

            if (compareNum != i){
                ball++;
                continue;
            }

            strike++;
        }

        baseballScore.add(strike);
        baseballScore.add(ball);

        return baseballScore;
    }
}
