package baseball;

import java.util.List;


public class BaseballGame {

    private static final boolean end = false;

    public void gameStart(){

        List<Integer> randomNumber = Number.getRandomNumber();

        while(!end){
            List<Integer> userNumber = Number.inputUserNumber();
        }
    }
}
