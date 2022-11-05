package baseball;

import baseball.View.Message;
import baseball.Game;
import baseball.Controller;

import java.util.ArrayList;

public class GameService {
    User user;
    Game game;

    public void setGame(){
        game = new Game();
        game.setAnswerNumber();
    }

    public void startGame() throws IllegalArgumentException{
        user = new User();
        while(game.strike!=3){
            user.setUserNumber();
            game.calculateStrike(user.userNumber);
            game.calculateBall(user.userNumber);
            Message.printResultMessage(game.strike,game.ball);
        }
        Message.printEndMessage();
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
