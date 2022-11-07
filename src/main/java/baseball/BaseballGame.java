package baseball;

import baseball.constant.Message;
import baseball.util.RandomNumberGenerator;
import java.util.List;

public class BaseballGame {

    public final static int MAX_NUMBER_SIZE = 3;

    public void run() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        UserInput userInput = new UserInput();
        GameResult gameResult = new GameResult();

        System.out.println(Message.GAME_START);
        List<Integer> randomNumber = randomNumberGenerator.generateRandomNumber();
        do {
            int[] userNumber = userInput.getUserInput();
            gameResult.compareNumbers(randomNumber, userNumber);

        } while (true);
    }
}
