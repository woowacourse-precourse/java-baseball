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

    public int countStrike(ArrayList<Integer> computerNum, ArrayList<Integer> playerNum){
        int count=0;
        for (int numberIdx = 0; numberIdx <COMPUTER_NUMBER_SIZE; numberIdx++) {
            count = checkStrikeComputerNumPlayerNum(computerNum, playerNum, count, numberIdx);
        }
        return count;
    }

    private static int checkStrikeComputerNumPlayerNum(ArrayList<Integer> computerNum, ArrayList<Integer> playerNum, int count, int i) {
        if(computerNum.get(i)== playerNum.get(i)){
            count++;
        }
        return count;
    }

    public int countBall(ArrayList<Integer> computerNum, ArrayList<Integer> playerNum){
        int count=0;
        for (int computerNumIdx = 0; computerNumIdx <COMPUTER_NUMBER_SIZE; computerNumIdx++) {
            count = getBallCountCompareToPlayerNum(computerNum, playerNum, count, computerNumIdx);
        }
        return count;
    }

    private static int getBallCountCompareToPlayerNum(ArrayList<Integer> computerNum, ArrayList<Integer> playerNum, int count, int computerNumIdx) {
        for(int playerNumIdx=0;playerNumIdx<COMPUTER_NUMBER_SIZE;playerNumIdx++){
            count = getBallCountNotSameIdx(computerNum, playerNum, count, computerNumIdx, playerNumIdx);
        }
        return count;
    }

    private static int getBallCountNotSameIdx(ArrayList<Integer> computerNum, ArrayList<Integer> playerNum, int count, int computerNumIdx, int playerNumIdx) {
        if(computerNumIdx != playerNumIdx) {
            count = checkBallComputerNumPlayerNum(computerNum, playerNum, count, computerNumIdx, playerNumIdx);
        }
        return count;
    }

    private static int checkBallComputerNumPlayerNum(ArrayList<Integer> computerNum, ArrayList<Integer> playerNum, int count, int i, int j) {
        if(computerNum.get(i)== playerNum.get(j)){
            count++;
        }
        return count;
    }

    public String getHint(ArrayList<Integer> computerNum, ArrayList<Integer> playerNum){
        int strike = countStrike(computerNum,playerNum);
        int ball = countBall(computerNum, playerNum);
        

    }
}
