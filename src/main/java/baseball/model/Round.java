package baseball.model;

import baseball.dto.Hints;
import baseball.dto.Number;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Round {

    private final int COUNT_NUMBER = 3;

    private Hints hints;

    public Round() {}

    public void startNewRound(User user, Computer computer)  {
        OutputView.printRoundStart();
        readNumbers(user);
        getHints(user, computer);
        OutputView.printRoundResult(hints);
    }

    private void readNumbers(User user) {
        int inputInt = InputView.readInt();
        user.inputNewNumbers(inputInt);
    }

    private void getHints(User user, Computer computer) {
        hints = new Hints();
        for (int index = 0; index < COUNT_NUMBER; index++) {
            Hint hint = getHint(index, user, computer);
            hints.addHint(hint);
        }
    }

    private Hint getHint(int index, User user, Computer computer) {
        if (isStrike(index, user, computer)) {
            return Hint.STRIKE;
        }
        if (isBall(index, user, computer)) {
            return Hint.BALL;
        }
        return Hint.NOTHING;
    }

    public boolean isThreeStrike(){
        int countStrike = hints.findHintCount(Hint.STRIKE);
        return (countStrike == 3);
    }

    private boolean isBall(int index, User user, Computer computer) {
        // 이전 인덱스 : 0 -> 2
        int prevIndex = (index + 2) % 3;
        // 이후 인덱스 : 2 -> 0
        int nextIndex = (index + 1) % 3;

        Number prevComputerNumber = computer.findComputerNumber(prevIndex);
        Number nextComputerNumber = computer.findComputerNumber(nextIndex);
        Number userNumber = user.findUserNumber(index);
        
        boolean isPrevBall = userNumber.equals(prevComputerNumber);
        boolean isNextBall = userNumber.equals(nextComputerNumber);

        return  isPrevBall || isNextBall;
    }

    private boolean isStrike(int index, User user, Computer computer) {
        return computer.findComputerNumber(index)
                .equals(user.findUserNumber(index));
    }
}
