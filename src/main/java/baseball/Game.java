package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> userNumber = new ArrayList<>();
    private List<Integer> computerNumber = new ArrayList<>();

    public Game(String userNumber) {
        this.userNumber = Change.numberToList(userNumber);
        this.computerNumber = Generate.randomNumber();
    }

    public void start(){

    }
}
