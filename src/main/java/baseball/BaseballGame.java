package baseball;

import java.util.List;

public class BaseballGame {
    public static int strike;
    public static int ball;
    public static List<Integer> comNum;
    public static List<Integer> userNumers;



    public static void ballCount(){
        strike = 0;
        ball = 0;
        for(int i = 0; i < userNumers.size(); i++) {
            //스트라이크 카운트
            if (comNum.indexOf(userNumers.get(i)) == i) {
                strike++;
                continue;
            }
            //볼 카운트
            if (comNum.contains(userNumers.get(i))) {
                ball++;
            }
        }
    }

    public static String hintPrint(){
        if(ball != 0 && strike != 0){
            return (ball + "볼 " + strike + "스트라이크");
        }
        if(ball ==0 && strike != 0){
            return(strike + "스트라이크");
        }
        if(ball != 0 && strike ==0){
            return (ball + "볼");
        }
        return ("낫싱");
    }
}
