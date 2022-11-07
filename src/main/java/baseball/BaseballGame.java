package baseball;

import baseball.constant.Message;
import baseball.util.RandomNumberGenerator;
import camp.nextstep.edu.missionutils.Console;
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
            gameResult.showResult();

        } while (gameResult.strike != 3);
    }

    public void end() {
        System.out.println(Message.GAME_END);
    }

    public boolean rerun() {
        boolean flag = false;

        System.out.println(Message.GAME_RESTART);
        Integer userInput = Integer.valueOf(Console.readLine());

        if (userInput == 1) {
            flag = true;
        }
        if (userInput == 2) {
            flag = false;
        }
        if (userInput != 1 && userInput != 2) {
            throw new IllegalArgumentException();
        }
        return flag;
    }
}
