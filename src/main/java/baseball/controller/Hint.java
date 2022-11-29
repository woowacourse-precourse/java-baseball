package baseball.controller;

import static baseball.model.Number.LENGTH;

import baseball.model.Number;
import baseball.model.Player;
import baseball.view.InputView;
import java.util.List;
import java.util.ListIterator;

public class Hint {
    String readLine;
    List<Integer> player;
    List<Integer> computer;
    int ball;
    int strike;


    public Hint() {
        this.readLine = new InputView().putReadLine();
        this.player = new Player().generateNumber(readLine);
        this.computer = Number.generateNumber();
        this.ball = 0;
        this.strike = 0;
    }

    public void buildHint() {
        computer.forEach( computerNumber -> comparing(computerNumber) );
    }

    private void comparing(int computerNumber) {

        ListIterator<Integer> playerList = player.listIterator();
        int playerNumber = playerList.next();

        if ( computer.contains(playerNumber) && computerNumber != playerNumber) {   ball++;  }
        if ( computerNumber == playerNumber) {   strike++;  }

    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
