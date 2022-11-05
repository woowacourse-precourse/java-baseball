package baseball;

import baseball.View.Message;
import baseball.Game;
import baseball.Controller;

import java.util.ArrayList;

public class GameService {
    private static ArrayList<Integer> userNumber = new ArrayList<>();
    Game game;

    public void setGame(){
        game = new Game();
        game.setAnswerNumber();
        System.out.println(game.answerNumber);
    }

    public void startGame() throws IllegalArgumentException{
        while(game.strike!=3){
            setUserNumber();
            game.calculateStrike(userNumber);
            game.calculateBall(userNumber);
            Message.printResultMessage(game.strike,game.ball);
        }
        Message.printEndMessage();
    }

    private void setUserNumber() {
        userNumber = User.setUserNumber();
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
