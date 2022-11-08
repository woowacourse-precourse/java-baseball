package util.impl;

import util.Comparator;

import java.util.ArrayList;
import java.util.List;

public class InputValueComparator implements Comparator {
    @Override
    public List<Integer> doIntCompare(List<Integer> standard, List<Integer> target) {
        List<Integer> result = new ArrayList<>();
        int ball = 0, strike = 0;
        for(int i = 0 ; i < 3 ; i++) {
            ball += countBall(standard, target.get(i), i);
        }
        strike = countStrike(standard, target);

        result.add(ball);
        result.add(strike);
        if(ball == 0 && strike == 0) {
            result.add(1);
        }
        else {
            result.add(0);
        }
        return result;
    }

    private Integer countBall(List<Integer> standard, int target, int positon) {
        int ball = 0;
        for(int i = 0 ; i < 3 ; i++) {
            if(standard.get(i) == target && i != positon){
                ball++;
            }
        }
        return ball;
    }

    private Integer countStrike(List<Integer> standard, List<Integer> target) {
        int strike = 0;
        for(int i = 0 ; i < 3 ; i++) {
            if(standard.get(i) == target.get(i)){
                strike++;
            }
        }
        return strike;
    }

}
