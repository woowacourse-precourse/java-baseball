package baseball;

import baseball.constant.Message;
import baseball.util.RandomNumberGenerator;
import java.util.List;

public class BaseballGame {

    public void run(){
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        UserInput userInput = new UserInput();

        System.out.println(Message.GAME_START);
        List<Integer> randomNumber = randomNumberGenerator.generateRandomNumber();
        while(true) {
            int[] userNumber = userInput.getUserInput();

        }
    }
}
