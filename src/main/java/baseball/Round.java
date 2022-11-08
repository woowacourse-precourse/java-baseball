package baseball;

import org.mockito.exceptions.misusing.CannotVerifyStubOnlyMock;

public class Round {

    private final int COUNT_NUMBER = 3;

    private static Round instance;

    private Hints hints;

    private Round() {}

    public static Round getRound() {
        if (instance == null){
            instance = new Round();
        }
        return instance;
    }

    public void startNewRound(User user, Computer computer)  {
        Print.printRoundStart();
        readNumbers(user);
        getHints(user, computer);
        Print.printRoundResult(hints);
    }

    private void readNumbers(User user) {
        int inputInt = Input.readInt();
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
