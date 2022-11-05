package game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomNumber {
    private List<Integer> randomNumber;
    public RandomNumber() {
        randomNumber = new ArrayList<>();
    }
    public List<Integer> getRandomNumber() {
        return this.randomNumber;
    }
    public void getList() {
        while(randomNumber.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if(!randomNumber.contains(randomNum)) {
                randomNumber.add(randomNum);
            }
        }
        System.out.println(randomNumber);
    }
    public void resetNumber() {
        randomNumber.clear();
    }
}
