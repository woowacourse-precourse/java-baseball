package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    private static List<Integer> createTargetNums(){
        Random r = new Random();
        List<Integer> targetNums = new ArrayList<>();
        int digit = 3;
        while(digit > 0 ){
            targetNums.add(r.nextInt(9)+1);
        }

        return targetNums;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
