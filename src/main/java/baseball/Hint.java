package baseball;

import java.util.List;

import static baseball.Constant.*;

public class Hint {

    private int strike;
    private int ball;
    boolean threeStrike;

    public void hintCalculator(List<String> comNumber, List<String> userNumber){
        strike=0;
        ball=0;

        isStrikeOrBall(comNumber,userNumber);

        if(strike==3) threeStrike=true;
        printHintMessage();
    }

    private void isStrikeOrBall(List<String> comNumber, List<String> userNumber){
        for(int comIndex=0;comIndex<comNumber.size();comIndex++){
            if(comNumber.get(comIndex).equals(userNumber.get(comIndex))){
                strike++;
                continue;
            }
            if(comNumber.contains(userNumber.get(comIndex))){
                ball++;
            }
        }
    }
    private void printHintMessage(){
        if(strike==3){
            System.out.println(strike+ strikeMessage);
            return;
        }
        if(strike==0 && ball==0) {
            System.out.println(nothingMessage);
            return;
        }
        if(strike>0 && ball==0){
            System.out.println(strike+ strikeMessage);
            return;
        }
        if(strike==0 && ball>0){
            System.out.println(ball+ballMessage);
            return;
        }
        System.out.println(ball + ballMessage + " " + strike + strikeMessage);
    }
}
