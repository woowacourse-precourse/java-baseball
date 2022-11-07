package baseball;

import baseball.constant.Message;
import baseball.util.RandomNumberGenerator;
import java.util.List;

public class BaseballGame {

    public void run(){
        System.out.println(Message.GAME_START);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> randomNumber = randomNumberGenerator.generateRandomNumber();
    }
}
