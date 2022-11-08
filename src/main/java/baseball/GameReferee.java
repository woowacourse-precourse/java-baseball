package baseball;

import java.util.List;

public class GameReferee {

    public GameReferee() {
    }

    private boolean checkNothing(List<Integer> computer, List<Integer> myNumber, int i) {

        boolean checkNothing = (myNumber.contains(computer.get(i)));

        return checkNothing;
    }
    
}