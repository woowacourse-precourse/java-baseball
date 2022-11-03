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

    private int verifyStrikes(List<Integer> playerNumbers) {

        int strikeCount = 0;
        for(int index = 0; index<computerNumbers.size(); index++){
            if(playerNumbers.get(index).equals(computerNumbers.get(index))){
                strikeCount += 1;
            }
        }

        return strikeCount;
    }

}
