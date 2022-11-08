package domain;

import java.util.List;
import java.util.Objects;
import ui.Input;
import ui.Messages;
import ui.Output;


public class Game {

    private final int MAX_LEN;
    private static final int REPLAY_GAME = 1;
    private static final int GUESSING_NUMBER = 2;
    private RandomBallsGenerator computer;
    private GameResultJudgement judge;

    public Game(final int MAX_LEN) {
        this.MAX_LEN = MAX_LEN;
        computer = new RandomBallsGenerator(MAX_LEN);
        judge = new GameResultJudgement(MAX_LEN);
    }

    public void run(Input input, Output output) {
        String toBeContinued;
        output.printOut(Messages.START_GAME.message());
        do {
            play(input, output);
            output.printOut(Messages.REQUEST_RESTART_GAME_INPUT.message());
            toBeContinued = input.scan(REPLAY_GAME, MAX_LEN);
        } while (Objects.equals(toBeContinued, "1"));
    }

    public void play(Input input, Output output) {
        final int START_INCLUSIVE = 1;
        final int END_INCLUSIVE = 9;
        String computerNumber = computer.generateBalls(START_INCLUSIVE, END_INCLUSIVE);
        boolean retry;
        do {
            output.printOut(Messages.REQUEST_NUMBER_INPUT.message());
            String userInputNumber = input.scan(GUESSING_NUMBER, MAX_LEN);
            List<Integer> judgement = judge.judgeStrikeBallNothing(computerNumber, userInputNumber);
            output.printOutAfterConversion(judgement);
            retry = isMatch(computerNumber, userInputNumber);
            if (isMatch(computerNumber, userInputNumber)) {
                output.printOut(Messages.END_GAME.message());
            }
        } while (!retry);
    }

    public boolean isMatch(String computer, String user) {
        return Objects.equals(computer, user);
    }
}
