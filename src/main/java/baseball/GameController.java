package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameController {
    private GameView gameView;
    private Hint hint;
    private NumberGenerator numberGenerator;
    private UserAnswer userAnswer;

    public void run() {
        String status;
        init();
        gameView.printStart();
        do {
            numberGenerator.init();
            playing();
            gameView.printRestart();
            status = Console.readLine();
        } while (!status.equals(ConstGame.EXIT));
    }

    private void init() {
        gameView = new GameView();
        numberGenerator = new NumberGenerator();
        userAnswer = new UserAnswer();
        hint = new Hint();
    }

    private void playing() {
        do {
            gameView.printInput();
            String userInput = Console.readLine();
            userAnswer.StringtoList(userInput);

            List<Integer> computer = numberGenerator.getComputer();
            List<Integer> userNumber = userAnswer.getUserNumber();

            hint.getHint(userNumber, computer);
            gameView.printHint(hint.getBall(), hint.getStrike());
        } while (hint.getStrike() != 3);
    }
}
