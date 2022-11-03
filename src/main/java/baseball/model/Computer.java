package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {

    private static final int MIN_RANGE_NUMBER=1;
    private static final int MAX_RANGE_NUMBER = 9;
    private static final int COMPUTER_NUMBER_SIZE=3;
    private ArrayList<Integer> computerNumber;

    public void generateComputerNumberThree(){
        computerNumber = new ArrayList<>();
        while(computerNumber.size()<COMPUTER_NUMBER_SIZE){
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
            addComputerNumber(randomNumber);
        }
    }

    private void addComputerNumber(int randomNumber) {
        if(!computerNumber.contains(randomNumber)){
            computerNumber.add(randomNumber);
        }
    }

    public ArrayList<Integer> getComputerNumber() {
        return computerNumber;
    }
}
