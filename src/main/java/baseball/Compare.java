package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compare {
    public Map<String, Integer> getResultToMap(List<Integer> randomNumberList, List<Integer> inputNumberList){
        Map<String, Integer> resultToMap = new HashMap<>();

        int numberOfStrike = getNumberOfStrike(randomNumberList, inputNumberList);
        int numberOfBall = getNumberOfBall(randomNumberList, inputNumberList);
        resultToMap.put("스트라이크", numberOfStrike);
        resultToMap.put("볼", numberOfBall - numberOfStrike);

        return resultToMap;
    }

    public int getNumberOfStrike(List<Integer> randomNumberList, List<Integer> inputNumberList){
        int numberOfStrike = 0;
        for (int digit = 0; digit < randomNumberList.size(); digit++){
            if (randomNumberList.get(digit).equals(inputNumberList.get(digit))){
                numberOfStrike += 1;
            }
        }
        return numberOfStrike;
    }

    public int getNumberOfBall(List<Integer> randomNumberList, List<Integer> inputNumberList){
        int numberOfBall = 0;
        for (Integer inputNumber : inputNumberList){
            if (randomNumberList.contains(inputNumber)){
                numberOfBall += 1;
            }
        }
        return numberOfBall;
    }
}
