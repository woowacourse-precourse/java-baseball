package baseball.game;

import java.util.ArrayList;
import java.util.List;


public class FindResultList {

    public List<String> findMatchingOrNothing( List<Integer> inputNumberList, List<Integer> randomNumberList ){
        List<String> result = new ArrayList<>();
        boolean nothing = true;

        for (int inputNumberDigit = 0; inputNumberDigit < inputNumberList.size(); inputNumberDigit++) {
            if (randomNumberList.contains( inputNumberList.get(inputNumberDigit) )) {
                result.add(findBallOrStrike(inputNumberDigit, inputNumberList,randomNumberList));
                nothing = false;
            }
        }
        if(nothing){
            result.add("낫싱");
            return result;
        }

        return result;
    }

    private String findBallOrStrike(int inputNumberDigit, List<Integer> inputNumberList, List<Integer> randomNumberList ) {
        String result = "";
        for(int randomNumberDigit=0; randomNumberDigit< randomNumberList.size(); randomNumberDigit++){
            if (inputNumberList.get(inputNumberDigit) == randomNumberList.get(randomNumberDigit)){
                result = isBallOrStrike(inputNumberDigit,randomNumberDigit);
            }
        }
        return result;
    }

    private String isBallOrStrike(int inputNumberDigit, int randomNumberDigit) {
        String result = "";
        if (inputNumberDigit == randomNumberDigit) {
            result = "스트라이크";
        }
        else if (inputNumberDigit != randomNumberDigit) {
            result = "볼";
        }
        return result;
    }


}
