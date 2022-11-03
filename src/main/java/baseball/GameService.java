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
    }
    private void setAnswerNumber(){
        RandomNumber randomNumber = new RandomNumber();
        answerNumber = randomNumber.setRandomNumber();
    }
    private void setUserNumber() {
        User user = new User();
        userNumber = user.setUserNumber();
    }

    public void startGame() throws IllegalArgumentException{
        int strike=0;
        int ball=0;
        while(strike!=3){
            setUserNumber();
            strike = calculateStrike();
            ball = calculateBall();
            printResult(strike,ball);
        }
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

    private void printResult(int strike, int ball){
        if(strike==3){
            System.out.println(strike+"스트라이크 모두 맞히셨습니다.");
        }
        else if(strike>0 || ball>0){
            System.out.println(ball+"볼 "+strike+"스트라이크 ");
        }
        else if(strike==0 && ball==0){
            System.out.println("낫싱");
        }
    }
}
