package domain;

import java.util.Objects;
import ui.Input;
import ui.Messages;
import ui.Output;

public class Game {

    private final int MAX_LEN;
    private static final String REPLAY_GAME = "1";
    private static final String GUESSING_NUMBER = "2";
    private final RandomBallsGenerator generator;
    private final GameResultJudgement judgement;

    public Game(final int MAX_LEN) {
        this.MAX_LEN = MAX_LEN;
        generator = new RandomBallsGenerator(MAX_LEN);
        judgement = new GameResultJudgement(MAX_LEN);
    }

    public void execute(Input input, Output output) {
        String toBeContinued;
        output.printOut(Messages.START_GAME.message());
        do {
            play(input, output);
            output.printOut(Messages.REQUEST_RESTART_GAME_INPUT.message());
            toBeContinued = input.scan(REPLAY_GAME, MAX_LEN);
        } while (Objects.equals(toBeContinued, REPLAY_GAME));
    }

    public void play(Input input, Output output) {
        final int START_INCLUSIVE = 1;
        final int END_INCLUSIVE = 9;
        String computerNumber = generator.generateBalls(START_INCLUSIVE, END_INCLUSIVE);
        boolean retryFlag;
        do {
            output.printOut(Messages.REQUEST_NUMBER_INPUT.message());
            String userNumber = input.scan(GUESSING_NUMBER, MAX_LEN);
            output.printOutAfterConversion(
                judgement.judgeStrikeBallNothing(computerNumber, userNumber));
            retryFlag = isMatch(computerNumber, userNumber);
            if (isMatch(computerNumber, userNumber)) {
                    output.printOut(Messages.END_GAME.message());
            }
        } while (!retryFlag);
    }

    public boolean isMatch(String computer, String user) {
        return Objects.equals(computer, user);
    }
}
