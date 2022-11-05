package baseball;

import baseball.View.Message;
import baseball.Game;
import baseball.Controller;

import java.util.ArrayList;

public class GameService {
    private static ArrayList<Integer> userNumber = new ArrayList<>();
    public Game game;
    public void setGame(){
        game = new Game();
        game.setAnswerNumber();
        System.out.println(game.answerNumber);
    }

    public void startGame() throws IllegalArgumentException{
        while(game.strike!=3){
            setUserNumber();
            game.strike = calculateStrike();
            Message.printResultMessage(game.strike,calculateBall());
        }
        Message.printEndMessage();
    }
    private void setUserNumber() {
        userNumber = User.setUserNumber();
    }
    private int calculateStrike(){
        int strikeCount=0;
        for(int i=0; i<3; i++){
            if(game.answerNumber.get(i) == userNumber.get(i)){
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int calculateBall(){
        int ballCount=0;
        for(int i=0; i<3; i++){
            if(game.answerNumber.contains(userNumber.get(i)) && game.answerNumber.get(i) != userNumber.get(i)){
                ballCount++;
            }
        }
        return ballCount;
    }

    public void finishGame() throws IllegalArgumentException{
        Message.printRestartMessage();
        if(User.finishInput()){
            Controller con = new Controller();
            con.run();
        }
        return;
    }
}
