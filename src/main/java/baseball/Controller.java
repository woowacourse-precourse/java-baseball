package baseball;

import baseball.domain.RandomNumber;
import baseball.domain.User;
import baseball.service.GameService;

import java.util.ArrayList;

public class Controller {
    //객체를 모두 가져온다.
    GameService Game = new GameService();

    public void playGame(){

        Game.initScore();
        ArrayList<Integer> User=getUser();
        ArrayList<Integer> RandomNum=getRandomNumber();
        Game.getBallCount(User,RandomNum);
        Game.getStrikeCount(User,RandomNum);
        Game.finalScore();
    }

    public static ArrayList getUser(){
        return User.makeUserList();
    }
    public static ArrayList getRandomNumber(){
        return RandomNumber.makeRandomNum();
    }
}
