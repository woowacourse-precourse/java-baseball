package baseball.model;

import baseball.HintInfo;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static baseball.constValue.Constants.*;
import static baseball.constValue.Constants.ExceptionMessage.RESTART_INPUT_ERROR_MESSAGE;
import static baseball.constValue.Constants.RestartOrExitInfo.EXIT_NUMBER;
import static baseball.constValue.Constants.RestartOrExitInfo.RESTART_NUMBER;

public class Computer {

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

    public boolean isRestart(String restartInput){
        checkNotRestartInput(restartInput);
        if(restartInput.equals(RESTART_NUMBER)){
            return true;
        }
        return false;
    }

    public void checkNotRestartInput(String input){
        if(isNotRestartOrCloseInput(input)){
            throw new IllegalArgumentException(RESTART_INPUT_ERROR_MESSAGE);
        }
    }

    private static boolean isNotRestartOrCloseInput(String input) {
        return !input.equals(RESTART_NUMBER) && !input.equals(EXIT_NUMBER);
    }

    public String getHint(ArrayList<Integer> computerNum, ArrayList<Integer> playerNum){
        int strikeCount = countStrike(computerNum,playerNum);
        int ballCount = countBall(computerNum, playerNum);
        return getHintInfo(strikeCount, ballCount);
    }

    private static String getHintInfo(int strike, int ball) {
        return Arrays.stream(HintInfo.values()).filter(s -> (s.getBallCount() == ball && s.getStrikeCount() == strike))
                .map(s -> s.getTitle()).collect(Collectors.toList()).get(0);
    }

    public int countStrike(ArrayList<Integer> computerNum, ArrayList<Integer> playerNum){
        int count=0;
        for (int numberIdx = 0; numberIdx <COMPUTER_NUMBER_SIZE; numberIdx++) {
            count = checkStrikeComputerNumPlayerNum(computerNum, playerNum, count, numberIdx);
        }
        return count;
    }

    private static int checkStrikeComputerNumPlayerNum(ArrayList<Integer> computerNum, ArrayList<Integer> playerNum, int count, int sameIdx) {
        if(computerNum.get(sameIdx)== playerNum.get(sameIdx)){
            count++;
        }
        return count;
    }

    public int countBall(ArrayList<Integer> computerNum, ArrayList<Integer> playerNum){
        int count=0;
        for (int computerNumIdx = 0; computerNumIdx <COMPUTER_NUMBER_SIZE; computerNumIdx++) {
            count = getBallCountComputerNumCompareToPlayerNum(computerNum, playerNum, count, computerNumIdx);
        }
        return count;
    }

    private static int getBallCountComputerNumCompareToPlayerNum(ArrayList<Integer> computerNum, ArrayList<Integer> playerNum, int count, int computerNumIdx) {
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

    private static int checkBallComputerNumPlayerNum(ArrayList<Integer> computerNum, ArrayList<Integer> playerNum, int count, int computerNumIdx, int playerNumIdx) {
        if(computerNum.get(computerNumIdx)== playerNum.get(playerNumIdx)){
            count++;
        }
        return count;
    }

    public boolean isNotThreeStrike(String hint){
        if(hint.equals(HintInfo.THREESTRIKE.getTitle())){
            return false;
        }
        return true;
    }

    public ArrayList<Integer> getComputerNumber() {
        return computerNumber;
    }

}
