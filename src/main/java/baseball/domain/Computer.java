package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    private ArrayList<Integer> randomNumbers;

    public void setRandomNumbers(ArrayList<Integer> randomNumbers){
        this.randomNumbers = randomNumbers;
    }
    public ArrayList<Integer> getRandomNumbers(){
        return randomNumbers;
    }

    public void createRandomNumbers() {
        randomNumbers = new ArrayList<>();
        while (randomNumbers.size() != 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!checkDuplication(number)) {
                randomNumbers.add(number);
            }
        }
    }

    public boolean checkDuplication(int number) {
        return randomNumbers.contains(number);
    }
}
