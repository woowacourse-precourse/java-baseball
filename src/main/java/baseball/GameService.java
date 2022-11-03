package baseball;

import baseball.RandomNumber;
import baseball.User;

import java.util.ArrayList;

public class GameService {
    private static ArrayList<Integer> answerNumber = new ArrayList<>();
    private static ArrayList<Integer> userNumber = new ArrayList<>();

    public void setGame(){
        setAnswerNumber();
        setUserNumber();
    }

    private void setAnswerNumber(){
        RandomNumber randomNumber = new RandomNumber();
        answerNumber = randomNumber.setRandomNumber();
    }
    private void setUserNumber(){
        User user = new User();
        userNumber = user.setUserNumber();
    }
}
