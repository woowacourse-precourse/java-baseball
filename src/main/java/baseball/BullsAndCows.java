package baseball;

import java.util.List;
import java.util.Objects;

public class BullsAndCows {
    private final ComputerBallsGenerator COMPUTER;
    private UserBallsInput user;
    private GameResultJudgement judge;
    private GameResultPrinter printer;
    public BullsAndCows() {
        COMPUTER = new ComputerBallsGenerator();
        user = new UserBallsInput();
        judge = new GameResultJudgement();
        printer = new GameResultPrinter();
    }

    public void play() {
        String computerNumber = COMPUTER.ballsGenerator();
        boolean retry;
        do {
            printer.printInput();
            String userNumber = user.inputNumber();
            List<Integer> judgement = judge.judgeStrikeBallNothing(computerNumber, userNumber);
            printer.printer(judgement);
            retry = isMatch(computerNumber, userNumber);
            if (retry) {
                printer.printEnd();
            }
        } while (!retry);
    }

    public boolean isMatch(String computer, String user) {
        return Objects.equals(computer, user);
    }
}
