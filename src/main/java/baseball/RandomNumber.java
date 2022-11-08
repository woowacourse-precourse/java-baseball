package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    List<Integer> randomNumberList;

    public RandomNumber(){
        this.randomNumberList = getRandomNumberList();
    }

    public int getNumberOfStrike(List<Integer> userNumberList){
        int numberOfStrike = 0;
        for (int digit = 0; digit < this.randomNumberList.size(); digit++){
            if (this.randomNumberList.get(digit).equals(userNumberList.get(digit))){
                numberOfStrike += 1;
            }
        }
        return numberOfStrike;
    }

    public int getNumberOfBall(List<Integer> userNumberList){
        int numberOfBall = 0;
        for (Integer userNumber : userNumberList){
            if (this.randomNumberList.contains(userNumber)){
                numberOfBall += 1;
            }
        }
        return numberOfBall;
    }

    private List<Integer> getRandomNumberList(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
