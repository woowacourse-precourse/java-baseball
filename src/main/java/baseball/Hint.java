package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.Constant.*;

public class Hint {

    int strike;
    int ball;
    boolean threeStrike;

    public Hint(){
        this.strike = 0;
        this.ball = 0;
        this.threeStrike = false;
    }

    public void printHintMessage(){
        if(strike==3){
            System.out.println(strike+ strikeMessage);
        }
        else if(strike==0 && ball==0) {
            System.out.println(nothingMessage);
        }
        else System.out.println(ball + ballMessage + " " + strike + strikeMessage);
    }

    private void isStrikeOrBall(List<String> comNumber, List<String> userNumber){
        for(int comIndex=0;comIndex<comNumber.size();comIndex++){
            if(comNumber.get(comIndex).equals(userNumber.get(comIndex))){
                this.strike++;
                continue;
            }
            if(comNumber.contains(userNumber.get(comIndex))){
                this.ball++;
            }
        }
    }
    public void hintCalculator(HashSet<String> comNumber, List<String> userNumber){
        this.strike=0;
        this.ball=0;

        isStrikeOrBall(comNumber.stream()
                .collect(Collectors.toList())
                , userNumber);

        if(strike==3) this.threeStrike=true;
        printHintMessage();
    }
}
