package baseball;

import baseball.domain.RandomNumber;
import baseball.domain.User;
import baseball.service.GameService;

import java.util.ArrayList;

public class Controller {
    //객체를 모두 가져온다.
    public void playGame() throws IllegalArgumentException{
        ArrayList<Integer> RandomNum=getRandomNumbers();
        for (int i=0; i<3; i++){
            GameService Game = new GameService();
            Game.initScore();
            ArrayList<Integer> User = getUser();
            Game.getBallCount(User,RandomNum);
            Game.getStrikeCount(User,RandomNum);
            if (Game.finalScore()){
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
