package util;

import java.util.ArrayList;
import java.util.List;

public class Rule {

    public static List<Integer> getResult(List<Integer> comNumbers, List<Integer> userNumbers){

        List<Integer> result = new ArrayList<>();
        int nBalls = 0;
        int nStrikes = 0;
        for (int i=0; i< Constants.NUMBER_LENGTH; i++){
            if(isBall(comNumbers.get(i), userNumbers, i)) nBalls++;
            if(isStrike(comNumbers.get(i), userNumbers.get(i))) nStrikes++;
        }

        result.add(nBalls);
        result.add(nStrikes);

        return result;
    }

    private static boolean isBall(int comNum, List<Integer> userNumbers, int index) {
        return false;
    }
    private static boolean isStrike(int comNum, int userNum) {
        return false;
    }


}
