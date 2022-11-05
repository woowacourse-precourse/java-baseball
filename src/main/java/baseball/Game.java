package baseball;

import baseball.UserNumber;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final HintMessage hintMessage;
    private final ComputerNumber computerNumber;
    private final UserNumber userNumber;
    private List<Integer> com;
    private List<Integer> user;
    private boolean win;

    public Game() {
        hintMessage = new HintMessage();
        computerNumber = new ComputerNumber();
        userNumber = new UserNumber();
        com = new ArrayList<>();
        user = new ArrayList<>();
        win = true;
    }

    public void startGame() {
        computerNumber.makeRandomNumber();
        List<Integer> com = computerNumber.getComputerNumber();
        for (Integer integer : com) {
            System.out.print("computerValue = " + integer + " ");
        }
        System.out.println();
        do {
            userNumber.makeUserNumber();
            user = userNumber.getUserNumber();
            win = hintMessage.checkPoint(user, com);
        } while (win);
    }
}
