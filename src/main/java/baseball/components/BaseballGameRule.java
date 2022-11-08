package baseball.components;

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

    public Score generatePlayerScore(List<Integer> playerNumbers){
        int ballCount = countBalls(playerNumbers);
        int strikeCount = countStrikes(playerNumbers);
        Score playerScore = new Score(ballCount, strikeCount);
        return playerScore;
    }

    private int countBalls (List<Integer> playerNumbers) {

        int ballCount = 0;
        for(int index = 0; index<computerNumbers.size(); index++){
            if(computerNumbers.contains(playerNumbers.get(index))
                    && !computerNumbers.get(index).equals(playerNumbers.get(index))) {
                ballCount += 1;
            }
        }

        return ballCount;
    }

    private int countStrikes(List<Integer> playerNumbers) {

        int strikeCount = 0;
        for(int index = 0; index<computerNumbers.size(); index++){
            if(playerNumbers.get(index).equals(computerNumbers.get(index))){
                strikeCount += 1;
            }
        }

        return strikeCount;
    }


    public boolean isWin(Score playerScore){
        int strikeCount = playerScore.getStrike();
        if(strikeCount == 3){
            return true;
        }
        return false;
    }

}
