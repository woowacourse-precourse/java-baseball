package baseball;

import org.mockito.exceptions.misusing.CannotVerifyStubOnlyMock;

public class Round {

    private static Round instance;

    private Numbers numbers;
    private Hints hints;

    private Round() {}

    public static Round getRound() {
        if (instance == null){
            instance = new Round();
        }
        return instance;
    }

    public void startNewRound(Computer computer)  {
        Print.printRoundStart();
        readNumbers();
        getHints(computer);
        Print.printRoundResult(hints);
    }

    private void readNumbers() {
        int inputInt = Input.readInt();
        numbers = new Numbers(inputInt);
    }

    private void getHints(Computer computer) {
        hints = new Hints();
        for (int index = 0; index < 3; index++) {
            Hint hint = getHint(index, computer);
            hints.addHint(hint);
        }
    }

    public boolean isThreeStrike(){
        int countStrike = hints.findHintCount(Hint.STRIKE);
        return (countStrike == 3);
    }

    private Hint getHint(int index, Computer computer) {
        if (isStrike(index, computer)) {
            return Hint.STRIKE;
        }
        if (isBall(index, computer)) {
            return Hint.BALL;
        }
        return Hint.NOTHING;
    }

    private boolean isBall(int index, Computer computer) {
        // 이전 인덱스 : 0 -> 2
        int prevIndex = (index + 2) % 3;
        // 이후 인덱스 : 2 -> 0
        int nextIndex = (index + 1) % 3;

        Number prevComputerNumber = computer.findComputerNumber(prevIndex);
        Number nextComputerNumber = computer.findComputerNumber(nextIndex);
        Number userNumber = numbers.findNumber(index);
        
        boolean isPrevBall = userNumber.equals(prevComputerNumber);
        boolean isNextBall = userNumber.equals(nextComputerNumber);

        return  isPrevBall || isNextBall;
    }

    private boolean isStrike(int index, Computer computer) {
        return computer.findComputerNumber(index)
                .equals(numbers.findNumber(index));
    }
}
