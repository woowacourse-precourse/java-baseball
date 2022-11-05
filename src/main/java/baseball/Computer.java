package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> answerNumber = new ArrayList<>();
    private Integer strike = 0;
    private Integer ball = 0;

    public void makeAnswerNumber(){
        while(answerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }
    }

    public Integer checkStrike(int userNumber, int idx){
        if(answerNumber.contains(userNumber) && answerNumber.indexOf(userNumber) == idx){
            return 1;
        }
        return 0;
    }

    public Integer checkBall(int userNumber, int idx){
        if(answerNumber.contains(userNumber) && answerNumber.indexOf(userNumber) == idx){
            return 1;
        }
        return 0;
    }

    public void checkNumberCount(List<Integer> userNumber){

        for(int i=0; i<3; i++){
            strike += checkStrike(userNumber.get(i), i);
            ball += checkBall(userNumber.get(i), i);
        }
    }

    public void clearNumberCount(){
        strike = 0;
        ball = 0;
    }

    public String countResultString(){
        if(strike == 0 && ball == 0) {
            return "낫싱";
        } else if(ball == 0) {
            return strike + "스트라이크";
        } else if(strike == 0) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    public Integer getStrike() {
        return strike;
    }
}
