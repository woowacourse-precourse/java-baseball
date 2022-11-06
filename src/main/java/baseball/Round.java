package baseball;

public class Round {

    private final Computer computer;
    private Numbers numbers;
    private Hints hints;

    public Round(Computer computer) {
        this.computer = computer;
    }

    public void startNewRound()  {
        Print.printRoundStart();
        String inputString = Input.readString();
        numbers = Parse.StringToNumbers(inputString);
    }

    public void playRound() {
        hints = new Hints();
        for (int index = 0; index < 3; index++) {
            Hint hint = getHint(index);
            hints.addHint(hint);
        }
        Print.printRoundResult(hints);
    }

    public boolean isThreeStrike(){
        int countStrike = hints.findHintCount(Hint.STRIKE);
        return (countStrike == 3);
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

    private boolean isBall(int index) {
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

    private boolean isStrike(int index) {
        return computer.findComputerNumber(index)
                .equals(numbers.findNumber(index));
    }
}
