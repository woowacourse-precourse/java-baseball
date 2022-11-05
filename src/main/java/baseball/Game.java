package baseball;

import java.util.ArrayList;

public class Game {
    int strike;
    int ball;
    ArrayList<Integer> answerNumber;

    public void setAnswerNumber(){
        RandomNumber randomNumber = new RandomNumber();
        answerNumber = randomNumber.setRandomNumber();
    }

    public void calculateStrike(ArrayList<Integer> userNumber){
        strike=0;
        for(int i=0; i<3; i++){
            if(answerNumber.get(i) == userNumber.get(i)){
                strike++;
            }
        }
    }

    public void calculateBall(ArrayList<Integer> userNumber){
        ball=0;
        for(int i=0; i<3; i++){
            if(answerNumber.contains(userNumber.get(i)) && answerNumber.get(i) != userNumber.get(i)){
                ball++;
            }
        }
    }
}
