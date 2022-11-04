package baseball;

import java.util.HashMap;

public class Round {

    private final Computer computer;
    private Numbers numbers;
    HashMap<Hint, Integer> hintCountMap = new HashMap<>();

    public Round(Computer computer) {
        this.computer = computer;
    }

    public void startNewRound()  {
        Print.printRoundStart();
        String inputString = Input.readString();
        numbers = Parse.StringToNumbers(inputString);
    }

    public void playRound() {
        hintCountMap.clear();
        for (int index = 0; index < 3; index++) {
            Hint hint = getHint(index);
            putHintCountMap(hint, hintCountMap);
        }
        Print.printRoundResult(hintCountMap);
    }

    public boolean isThreeStrike(){
        int countStrike = hintCountMap.getOrDefault(Hint.STRIKE, 0);
        return (countStrike == 3);
    }

    private void putHintCountMap (Hint hint, HashMap<Hint, Integer> hintCountMap) {
        if (!hintCountMap.containsKey(hint)) {
            hintCountMap.put(hint, 0);
        }
        hintCountMap.put(hint, hintCountMap.get(hint) + 1);
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

        boolean isPrevBall = computer.findComputerNumber(prevIndex)
                .equals(numbers.findNumber(index));
        boolean isNextBall = computer.findComputerNumber(nextIndex)
                .equals(numbers.findNumber(index));

        return  isPrevBall || isNextBall;
    }

    private boolean isStrike(int index) {
        return computer.findComputerNumber(index)
                .equals(numbers.findNumber(index));
    }
}
