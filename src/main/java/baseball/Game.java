package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.Message.*;

public class Game {

    private final SecretNumber secretNumber;
    private final ReplayNumber replayNumber;
    private final UserNumber userNumber;

    private int strikeCount;

    private List<Integer> inputDigits;
    private List<Integer> secretDigits;

    public Game() {

        secretNumber = new SecretNumber();
        replayNumber = new ReplayNumber();
        userNumber = new UserNumber();

        strikeCount = 0;

        System.out.println(GAME_START);
    }

    public void start() {

        secretNumber.generateSecretDigits();
        secretDigits = secretNumber.getSecretDigits();
        strikeCount = 0;
        userNumber.setSecretDigits(secretDigits);

        while (!isGameFinished()) {
            System.out.print(GAME_INPUT);
            String input = Console.readLine();

            inputDigits = userNumber.validate(input);
            strikeCount = userNumber.judge();
        }
    }

    private boolean isGameFinished(){

        if (strikeCount == INPUT_SIZE) {

            System.out.println(GAME_WIN);
            return true;
        }

        return false;
    }

    public boolean replay() {

        System.out.println(GAME_RESTART);

        String input = Console.readLine();

        return replayNumber.validate(input);
    }
}
