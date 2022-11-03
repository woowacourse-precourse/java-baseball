package baseball;

import baseball.service.UserInput;
import baseball.utils.ConsoleLog;
import baseball.utils.MakeRandom;

import java.util.List;

import static baseball.enums.Message.ENTER_NUMBER;
import static baseball.enums.Message.GAME_START;

public class Application {
    public static void main(String[] args) {
        ConsoleLog console = ConsoleLog.getInstance();
        MakeRandom makeRandom = MakeRandom.getInstance();

        console.println(GAME_START.message());
        List<Integer> computerNumbers = makeRandom.numbers();
        List<Integer> userNumbers = UserInput.number(ENTER_NUMBER.message());
    }
}
