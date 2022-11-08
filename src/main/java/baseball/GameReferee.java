package baseball;

import java.util.List;

public class GameReferee {

    public GameReferee() {
    }

    private boolean checkNothing(List<Integer> computer, List<Integer> myNumber, int i) {

        boolean checkNothing = (myNumber.contains(computer.get(i)));

        return checkNothing;
    }

    private boolean checkStrike(List<Integer> computer, List<Integer> myNumber, int i) {

        boolean checkStrike = (computer.indexOf(myNumber.get(i)) == i);

        return checkStrike;
    }

    private int countStrike(boolean checkNothing, boolean checkStrike) {
        int count = 0;
        if (checkNothing && checkStrike) {
            count = 1;
        }
        return count;
    }

}