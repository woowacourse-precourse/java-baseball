package baseball;

import controller.Controller;
import java.util.HashMap;
import model.Computer;
import model.GamePlayer;
import view.Input;
import view.Print;

public class Application {

    public static void main(String[] args) {
        Print.gameStart();
        Computer computer = new Computer();
        GamePlayer gamePlayer = new GamePlayer();
        computer.createDifferentRandomNumbers();
        while (true) {
            String numbers = Input.numbers();
            boolean correctInput = Controller.validateNumbers(numbers);
            Controller.handleException(correctInput);
            gamePlayer.saveNumbers(numbers);
            HashMap<String, Integer> result = Controller.compareTo(computer, gamePlayer);
            boolean threeStrike = Print.comparisonResult(result);
            if (!threeStrike) {
                continue;
            }
            boolean exit = Controller.gameOver();
            if (exit) {
                break;
            }
            computer.createDifferentRandomNumbers();
        }
    }
}
