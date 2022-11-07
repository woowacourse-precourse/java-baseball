package baseball;

import java.util.List;

public class Exception {
    public static void isOverThreeDigit(List<Integer> list){
        if(list.size() != 3){
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }
    }
}
