package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private final List<Integer> randomNumberList;

    public RandomNumber(){
        this.randomNumberList = setRandomNumberList();
    }

    public int getNumberOfStrike(List<Integer> userNumberList){
        int numberOfStrike = 0;
        for (int digit = 0; digit < this.randomNumberList.size(); digit++){
            if (this.randomNumberList.get(this.randomNumberList.size() - digit - 1).equals(userNumberList.get(digit))){
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

    public List<Integer> getRandomNumberList() {
        return this.randomNumberList;
    }

    private List<Integer> setRandomNumberList(){
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
