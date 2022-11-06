package baseball;

import java.util.List;

public class PlayGame {
    private int strike;
    private int ball;
    private List<Integer> computerNumber;
    private List<Integer> userNumber;

    PlayGame(List<Integer> setComputerNumber, List<Integer> setUserNumber){
        this.computerNumber = setComputerNumber;
        this.userNumber = setUserNumber;
    }

    public void compareNumberForStrike(){
        int digit = 0;
        int methodCallCount = 0;

        while(methodCallCount < 3){
            int beforeStrike = strike;

            countStrike(computerNumber.get(digit), userNumber.get(digit));
            digit = exceptStrikeNumber(beforeStrike, digit);

            digit++;
            methodCallCount++;
        }
    }

    private void countStrike(int computerStrikeNumber, int userStrikeNumber){
        if(computerStrikeNumber == userStrikeNumber){
            strike++;
        }
    }

    private int exceptStrikeNumber(int beforeStrike, int digit){
        if(beforeStrike != strike){
            computerNumber.remove(digit);
            userNumber.remove(digit);
            digit--;
        }
        return digit;
    }
}
