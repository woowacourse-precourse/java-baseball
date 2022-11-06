package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.Constant.*;

public class Hint {

    private int strike;
    private int ball;
    boolean threeStrike;

    public void printHintMessage(){
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
    public void hintCalculator(HashSet<String> comNumber, List<String> userNumber){
        strike=0;
        ball=0;

        isStrikeOrBall(comNumber.stream()
                .collect(Collectors.toList())
                , userNumber);

        if(strike==3) threeStrike=true;
        printHintMessage();
    }
}
