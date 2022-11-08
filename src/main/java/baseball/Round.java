package baseball;

import org.mockito.exceptions.misusing.CannotVerifyStubOnlyMock;

public class Round {

    private final int COUNT_NUMBER = 3;

    private static Round instance;

    private User user;
    private Computer computer;
    private Hints hints;

    private Round() {}

    public static Round getRound(Computer computer, User user) {
        if (instance == null){
            instance = new Round();
        }
        instance.computer = computer;
        instance.user = user;
        return instance;
    }

    public void startNewRound()  {
        Print.printRoundStart();
        readNumbers();
        getHints();
        Print.printRoundResult(hints);
    }

    private void readNumbers() {
        int inputInt = Input.readInt();
        user.inputNewNumbers(inputInt);
    }

    private void getHints() {
        hints = new Hints();
        for (int index = 0; index < COUNT_NUMBER; index++) {
            Hint hint = getHint(index);
            hints.addHint(hint);
        }
    }

    private Hint getHint(int index) {
        if (isStrike(index)) {
            return Hint.STRIKE;
        }
        if (isBall(index)) {
            return Hint.BALL;
        }
        return Hint.NOTHING;
    }

    public boolean isThreeStrike(){
        int countStrike = hints.findHintCount(Hint.STRIKE);
        return (countStrike == 3);
    }

    private boolean isBall(int index) {
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

    private boolean isStrike(int index) {
        return computer.findComputerNumber(index)
                .equals(user.findUserNumber(index));
    }
}
