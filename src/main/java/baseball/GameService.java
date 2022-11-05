package baseball;

import baseball.View.Message;

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
    public void startGame() throws IllegalArgumentException{
        int strike=0;
        while(strike!=3){
            setUserNumber();
            strike = calculateStrike();
            Message.printResultMessage(strike,calculateBall());
        }
        Message.printEndMessage();
    }
    private void setUserNumber() {
        userNumber = User.setUserNumber();
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

    public void finishGame() throws IllegalArgumentException{
        int flag;
        Message.printRestartMessage();
        flag=User.finishInput();
        if(flag==1){
            Game game = new Game();
            game.run();
        }
        else if(flag==2){
            return;
        }
    }
}
