package baseball.controller;

import baseball.model.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Hint extends Builder {

    public Hint() {
        super();
    }

    public List<Integer> buildHint() {

        computer.forEach( computerNumber -> comparing(computerNumber) );
        List<Integer> hint = new ArrayList<>();
        hint.add(ball);
        hint.add(strike);
        return hint;

    }

    private void comparing(int computerNumber) {

        ListIterator<Integer> playerList = player.listIterator();
        int playerNumber = playerList.next();

        if (computer.contains(playerNumber) && computerNumber != playerNumber) {
            ball++;
        }
        if (computerNumber == playerNumber) {
            strike++;
        }

    }

}
