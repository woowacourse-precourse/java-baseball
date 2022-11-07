package util.impl;

import util.Comparator;

import java.util.ArrayList;
import java.util.List;

public class InputValueComparator implements Comparator {
    @Override
    public List<Integer> doIntCompare(List<Integer> standard, List<Integer> target) {
        List<Integer> result = new ArrayList<>();

        return null;
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


}
