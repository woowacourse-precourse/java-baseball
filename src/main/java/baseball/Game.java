package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.Message.INPUT_SIZE;
import static baseball.Message.REPLAY_INPUT;

public class Game {

    private final SecretNumber secretNumber;
    private final ReplayNumber replayNumber;
    private final UserNumber userNumber;

    private int ballCount;
    private int strikeCount;

    private List<Integer> inputDigits;
    private List<Integer> secretDigits;

    public Game() {
        secretNumber = new SecretNumber();
        replayNumber = new ReplayNumber();
        userNumber = new UserNumber();

        ballCount = 0;
        strikeCount = 0;
    }

    public void start() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        replayNumber.generateSecretDigits();
        secretDigits = replayNumber.getSecretDigits();

        while (isGameFinished()) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            inputDigits = userNumber.validate(input);
            userNumber.judge(inputDigits,secretDigits);
        }
    }

    private boolean isGameFinished(){
        if (strikeCount == INPUT_SIZE) {
            return true;
        }
        return false;
    }

    public boolean replay() {

        String input = Console.readLine();

        return replayNumber.validate(input);
    }
}
