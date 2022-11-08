package baseball;

import java.util.List;

public class MatchCounter {

    private static final int DEFAULT_VALUE = 0;
    private static final int COUNT_VALUE = 1;

    public static int countAllMatched(UserNumber userNumber, List<Integer> computeNumbers) {
        int result = DEFAULT_VALUE;
        for(int i = 0; i < userNumber.getUserNumbers().size(); i++){
            if(computeNumbers.contains(userNumber.getUserNumbers().get(i))){
                result += COUNT_VALUE;
            }
        }
        return result;
    }

    public static int countStrike(UserNumber userNumber, List<Integer> computeNumbers){
        int strike = DEFAULT_VALUE;
        for(int i = 0; i < userNumber.getUserNumbers().size(); i++){
            if(computeNumbers.get(i).equals(userNumber.getUserNumbers().get(i))){
                strike += COUNT_VALUE;
            }
        }
        return strike;
    }

}
