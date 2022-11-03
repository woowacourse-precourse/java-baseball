package baseball;

import baseball.RandomNumber;
import baseball.User;

import java.util.ArrayList;

public class GameService {
    private static ArrayList<Integer> answerNumber = new ArrayList<>();
    private static ArrayList<Integer> userNumber = new ArrayList<>();

    public void setGame(){
        setAnswerNumber();
        System.out.println(answerNumber);
        setUserNumber();
    }
    private void setAnswerNumber(){
        RandomNumber randomNumber = new RandomNumber();
        answerNumber = randomNumber.setRandomNumber();
    }
    private void setUserNumber(){
        User user = new User();
        userNumber = user.setUserNumber();
    }

    public void startGame(){
        int strike;
        int ball;
        strike = calculateStrike();
        ball = calculateBall();
    }
    private int calculateStrike(){
        int strikeCount=0;
        for(int i=0; i<3; i++){
            if(answerNumber.get(i) == userNumber.get(i)){
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int calculateBall(){
        int ballCount=0;
        for(int i=0; i<3; i++){
            if(answerNumber.contains(userNumber.get(i)) && answerNumber.get(i) != userNumber.get(i)){
                ballCount++;
            }
        }
        return ballCount;
    }
}
