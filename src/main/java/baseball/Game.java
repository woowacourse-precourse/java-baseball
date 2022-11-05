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
        int strikeCount=0;
        for(int i=0; i<3; i++){
            if(answerNumber.get(i) == userNumber.get(i)){
                strikeCount++;
            }
        }
        strike = strikeCount;
    }

    public void calculateBall(ArrayList<Integer> userNumber){
        int ballCount=0;
        for(int i=0; i<3; i++){
            if(answerNumber.contains(userNumber.get(i)) && answerNumber.get(i) != userNumber.get(i)){
                ballCount++;
            }
        }
        ball= ballCount;
    }
}
