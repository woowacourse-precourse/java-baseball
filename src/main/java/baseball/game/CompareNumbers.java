package baseball.game;

import static baseball.constant.GameConstant.BALL_LEN;
import static baseball.constant.GameConstant.ZERO;
import static baseball.constant.GameMessage.BALL;
import static baseball.constant.GameMessage.NOTHING;
import static baseball.constant.GameMessage.STRIKE;
import static baseball.game.BaseballGame.computerNumbers;
import static baseball.game.BaseballGame.userNumbers;

public class CompareNumbers {

    public int strike;
    public int ball;

    public void compareNumber(){
        int userNumber;
        int computerNumber;
        for(int i=ZERO;i<BALL_LEN;i++){
            userNumber = userNumbers.get(i);
            computerNumber = computerNumbers.get(i);
            if (!includeSame(userNumber)) continue;
            countStrike(userNumber,computerNumber);
            countBall(userNumber,computerNumber);
        }
    }

    public void userNumberResult(){
        if(ball==0 && strike==0) System.out.print(NOTHING);
        if(ball>0) System.out.print(ball + BALL);
        if(strike>0) System.out.print(strike + STRIKE);
        System.out.println();

    }

    public void resetStrikeBall(){
        strike=0;
        ball=0;
    }

    private boolean includeSame(int userNumber){
        return computerNumbers.contains(userNumber);
    }

    private void countStrike(int userNumber, int computerNumber){
        if (userNumber == computerNumber) strike++;
    }

    private void countBall(int userNumber, int computerNumber){
        if (userNumber != computerNumber) ball++;
    }

}
