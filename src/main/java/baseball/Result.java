package baseball;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Map<String, Integer> count = new HashMap<>();

    protected Result(Map<String, Integer> count){
        this.count = count;
    }

    protected boolean computeResult(){
        Integer strike = count.get("strike");
        Integer ball = count.get("ball");
        if(strike.equals(3)){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return true;
        } else if(strike != 0 && ball != 0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
            return false;
        } else if(strike == 0 && ball > 0){
            System.out.println(ball+"볼");
            return false;
        } else if(strike > 0 && ball == 0){
            System.out.println(strike+"스트라이크");
            return false;
        } else {
            System.out.println("낫싱");
            return false;
        }
    }
}
