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

    private int countBall(boolean checkNothing, boolean checkStrike) {
        int count = 0;
        if (checkNothing && (!checkStrike)) {
            count = 1;
        }
        return count;
    }

    public int Strike(List<Integer> myList, List<Integer> computerList) {
        int countStrike = 0;
        for (int i = 0; i < myList.size(); i++) {
            boolean ischeckNothing = checkNothing(myList, computerList, i);
            boolean ischeckStrike = checkStrike(myList, computerList, i);

            countStrike += countStrike(ischeckNothing, ischeckStrike);


        }
        return countStrike;
    }

}