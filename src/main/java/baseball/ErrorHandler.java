package baseball;

import java.io.IOException;
import java.util.List;

public class ErrorHandler {
    final static int BASEBALLLENGTH = 3;

    public boolean isLengthSizeis3(List<Integer> baseball){
        return baseball.size()==BASEBALLLENGTH;
    }

    public boolean isNotDuplicated(List<Integer> baseball) {
        boolean[] duplicate = new boolean[10];
        for(int i : baseball){
            if(!duplicate[i]) {
                duplicate[i] = true;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isAllDigit(String input)  {
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public boolean isRange(List<Integer> baseball) {
        boolean[] duplicate = new boolean[10];
        for (int i : baseball) {
            if (i < 1 || i > 9) return false;
        }
        return true;
    }
}
