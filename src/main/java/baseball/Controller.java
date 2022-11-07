package baseball;

import baseball.domain.RandomNumber;
import baseball.domain.User;
import baseball.service.GameService;
import baseball.utils.Constants;

import java.util.ArrayList;

public class Controller {

    public void playGame() throws IllegalArgumentException{
        ArrayList<Integer> RandomNum=getRandomNumbers();
        for (int i=0; i< Constants.GAME_NUM; i++){
            GameService Game = new GameService();
            Game.initScore();
            ArrayList<Integer> User = getUser();
            Game.getBallCount(User, RandomNum);
            Game.getStrikeCount(User, RandomNum);
            int isEnd = Game.finalScore();
            if (isEnd==Constants.END_GAME){
                break;
            }
            if (isEnd==Constants.RESTART_GAME){
                playGame();
                break;
            }
        }
    }

    public static ArrayList<Integer> getUser(){
        return User.makeUserList();
    }

    public static ArrayList<Integer> getRandomNumbers(){
        return RandomNumber.makeRandomNum();
    }
}
