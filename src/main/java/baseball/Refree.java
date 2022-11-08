package baseball;

import java.util.*;

public class Refree {
    Compare compare = new Compare();
    public String judgement(List<Integer> computer, List<Integer> player){
        int contains = compare.countContains(computer, player);
        int strike = compare.countStrike(computer, player);
        int ball = contains - strike;

        if (contains == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        else{
            return ball + "볼 " + strike + "스트라이크";
        }
    }
}
