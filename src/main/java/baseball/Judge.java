package baseball;

import java.util.List;

public class Judge {

    public int countBall(List<Integer> answer, List<Integer> userNumber) {
        int ballCount = 0;

        for(int n : userNumber){
            if(answer.contains(n))
                ballCount++;
        }

        return ballCount;
    }

    public int countStrike(List<Integer> answer, List<Integer> userNumber) {
        int strikeCount = 0;

        for(int i = 0; i < userNumber.size(); i++){
            if(answer.get(i) == answer.get(i))
                strikeCount++;
        }

        return strikeCount;
    }
}
