package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private User user;
    private Computer computer;

    private int strike;
    private int ball;
    private List<Integer> computerNumber;
    private List<Integer> userNumber;

    public void gameStart() {
        initGame();
        computerNumber = computer.getComputerNumber();

        do {
            userNumber = user.getUserNumber();
            calGame();

        } while (true);
    }

    public void initGame() {
        user = new User();
        computer = new Computer();

        strike = 0;
        ball = 0;
        computerNumber = new ArrayList<>();
        userNumber = new ArrayList<>();
    }

    public void calGame() {

    }
    public boolean gameContinue(){
        return true;
    }
}
