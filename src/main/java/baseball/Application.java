package baseball;

import baseball.controller.Game;
import baseball.logic.DigitNumber;
import baseball.logic.Judge;
import baseball.presentation.View;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public final static int CONTINUE = 1;
    public final static int EXIT = 2;
    public final static int DIGIT = 3;

    public static void main(String[] args) throws IllegalArgumentException {
        View view = View.getInstance(DIGIT);
        Judge judge = Judge.getInstance();
        DigitNumber digitNumber = DigitNumber.getInstance(DIGIT);
        int command = CONTINUE;

        while (command == CONTINUE) {
            Game game = new Game(view, judge, digitNumber);
            game.play();
            command = Integer.parseInt(Console.readLine());
            Validator.isRestartCommand(command);
        }
    }

}
