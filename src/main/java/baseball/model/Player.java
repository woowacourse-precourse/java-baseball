package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static baseball.model.NumberProperty.SIZE;

public class Player {

    private final List<Integer> player;

    public Player(String readPlayerNum) {
        player = new ArrayList<Integer>();
        Validator.validateNum(readPlayerNum);
        convertToIntList(readPlayerNum);
    }

    private void convertToIntList(String readPlayerNum) {
        for (int i = 0; i < SIZE.get(); i++) {
            player.add(readPlayerNum.charAt(i) - '0');
        }
    }

    public List<Integer> get() {
        return player;
    }
}
