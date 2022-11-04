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
        Game.getBallCount(getUser(), getRandomNumber());
        Game.getStrikeCount(getUser(), getRandomNumber());
        Game.finalScore();
    }

    public static ArrayList getUser(){
        return User.makeUserList();
    }
    public static ArrayList getRandomNumber(){
        return RandomNumber.makeRandomNum();
    }
}
