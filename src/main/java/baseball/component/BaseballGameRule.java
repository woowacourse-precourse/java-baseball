package baseball.component;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameRule {

    private List<Integer> computerNumbers;

    public BaseballGameRule(){
        computerNumbers = new ArrayList<>();
    }

    public void setComputerNumbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    /**
     * player의 수를 입력받아 ball, strike 수 파악
     *
     * @param playerNumbers 3개의 Integer List
     * @return playerScore.get(0) : ball 수
     *         playerScore.get(1) : strike 수
     */
    public List<Integer> verifyPlayerScore(List<Integer> playerNumbers){
        List<Integer> playerScore = new ArrayList<>();
        playerScore.add(verifyBalls(playerNumbers));
        playerScore.add(verifyStrikes(playerNumbers));
        return playerScore;
    }

    public boolean isWin(List<Integer> playerScore){
        int strikeCount = playerScore.get(1);
        if(strikeCount == 3){
            return true;
        }
        return false;
    }

    private int verifyStrikes(List<Integer> playerNumbers) {

        int strikeCount = 0;
        for(int index = 0; index<computerNumbers.size(); index++){
            if(playerNumbers.get(index).equals(computerNumbers.get(index))){
                strikeCount += 1;
            }
        }

        return strikeCount;
    }

    private int verifyBalls(List<Integer> playerNumbers) {

        int ballCount = 0;
        for(int index = 0; index<computerNumbers.size(); index++){
            if(computerNumbers.contains(playerNumbers.get(index))
                    && !computerNumbers.get(index).equals(playerNumbers.get(index))) {
                ballCount += 1;
            }
        }

        return ballCount;
    }

}
