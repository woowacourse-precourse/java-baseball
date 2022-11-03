package baseball;

import baseball.RandomNumber;

import java.util.ArrayList;

public class GameService {
    public void setGame(){
        ArrayList<Integer> answerNumber = new ArrayList<>();
        RandomNumber randomNumber = new RandomNumber();
        answerNumber = randomNumber.setRandomNumber();
    }
}
