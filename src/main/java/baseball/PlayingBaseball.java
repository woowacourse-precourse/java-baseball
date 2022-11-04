package baseball;

import java.util.ArrayList;
import java.util.List;

class PlayingBaseball {
    private final String numberOfComputer;
    private final String numberOfPlayer;
    private final int LENGTH = 3;
    private int strike = 0;
    private int ball = 0;
    private List indexOfStrike = new ArrayList<Integer>();

    PlayingBaseball (String numberComputer, String numberPlayer) {
        this.numberOfComputer = numberComputer;
        this.numberOfPlayer = numberPlayer;
    }

    int countStrikes () {
        for (int i = 0; i < LENGTH; i++) {
            if (numberOfComputer.charAt(i) == numberOfPlayer.charAt(i)) {
                indexOfStrike.add(i);
                strike += 1;
            }
        }
        return strike;
    }







}
