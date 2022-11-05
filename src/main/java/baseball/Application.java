package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static List<Integer> createTargetNums(){
        Random r = new Random();
        List<Integer> targetNums = new ArrayList<>();
        int digit = 3;
        while(digit > 0 ){
            int r_num = r.nextInt(9)+1;
            if (!targetNums.contains(r_num)) {
                targetNums.add(r_num);
                digit--;
            }
        }

        return targetNums;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
