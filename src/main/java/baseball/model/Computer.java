package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import static baseball.Constants.*;
import static baseball.Constants.RestartOrExitInfo.EXIT_NUMBER;
import static baseball.Constants.RestartOrExitInfo.RESTART_NUMBER;

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

    public ArrayList<Integer> getComputerNumber() {
        return computerNumber;
    }

    public boolean isNotThreeStrike(String hint){
        if(hint.equals("3스트라이크")){
            return false;
        }
        return true;
    }

    public boolean isRestart(String restartInput){
        checkNotRestartInput(restartInput);
        if(restartInput.equals(RESTART_NUMBER)){
            return true;
        }
        return false;
    }

    public void checkNotRestartInput(String input){
        if(isNotRestartInput(input)){
            throw new IllegalArgumentException("재시작 여부 숫자는 1,2만 가능합니다.");
        }
    }

    private static boolean isNotRestartInput(String input) {
        return !input.equals(RESTART_NUMBER) && !input.equals(EXIT_NUMBER);
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

        String hint = "";
        hint = getNothing(strike, ball,hint);
        hint = getStrikeNoBall(strike, ball,hint);
        hint = getBallNoStrike(strike, ball,hint);
        hint = getStrikeAndBall(strike, ball,hint);

        return hint;
    }

    private static String getStrikeAndBall(int strike, int ball,String hint) {
        if (isStrikeAndBall(strike, ball)) {
            return ball + "볼 " + strike + "스트라이크";
        }
        return hint;
    }

    private static String getBallNoStrike(int strike, int ball,String hint) {
        if(isBallNoStrike(strike, ball)){
            return ball + "볼";
        }
        return hint;
    }

    private static String getStrikeNoBall(int strike, int ball,String hint) {
        if(isStrikeNoBall(strike, ball)){
            return strike + "스트라이크";
        }
        return hint;
    }

    private static String getNothing(int strike, int ball,String hint) {
        if(isNothing(strike, ball)){
            return  "낫싱";
        }
        return hint;
    }

    private static boolean isStrikeAndBall(int strike, int ball) {
        return strike > 0 && ball > 0;
    }

    private static boolean isBallNoStrike(int strike, int ball) {
        return strike == 0 && ball > 0;
    }

    private static boolean isStrikeNoBall(int strike, int ball) {
        return strike > 0 && ball == 0;
    }

    private static boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }
}
