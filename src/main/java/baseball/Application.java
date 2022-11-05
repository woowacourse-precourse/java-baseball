package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        numberBaseballGame();
    }

    private static void numberBaseballGame(){
        PrepareGame prepareGame = new PrepareGame();
        List<Integer> computerNumber = prepareGame.setComputerNumber();
        String userNumber = prepareGame.setUserNumber();
    }
}
