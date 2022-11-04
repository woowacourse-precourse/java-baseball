package baseball;

import java.util.List;

public class Comparison {

    public static int compare(UserNumber userNumber, List<Integer> computeNumbers) {
        int result = 0;
        for(int i = 0; i < userNumber.getUserNumbers().size(); i++){
            if(computeNumbers.contains(userNumber.getUserNumbers().get(i))){
                result += 1;
            }
        }
        return result;
    }

    public static int findStrike(UserNumber userNumber, List<Integer> computeNumbers){
        int strike = 0;
        for(int i = 0; i < userNumber.getUserNumbers().size(); i++){
            if(computeNumbers.get(i).equals(userNumber.getUserNumbers().get(i))){
                strike += 1;
            }
        }
        return strike;
    }

}
