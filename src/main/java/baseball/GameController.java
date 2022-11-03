package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameController {
    public static void run(){
        String status;
        do {
            GameView gameView = new GameView();
            gameView.printStart();
            NumberGenerator numberGenerator = new NumberGenerator();
            numberGenerator.init();
            Hint hint = new Hint();
            while(true) {
                gameView.printInput();
                String userInput = Console.readLine();
                UserAnswer userAnswer = new UserAnswer();
                userAnswer.StringtoList(userInput);

                List<Integer> computer = numberGenerator.getComputer();
                List<Integer> userNumber = userAnswer.getUserNumber();

                hint.getHint(userNumber, computer);
                gameView.printHint(hint.getBall(), hint.getStrike());
                if (hint.getStrike() == 3) break;
            }
            gameView.printRestart();
            status = Console.readLine();
        } while(!status.equals("2"));
    }
}
