package baseball.model;

import static baseball.model.Computer.COMPUTER;
import static baseball.model.Player.PLAYER;

import baseball.view.InputView;
import java.util.List;

public abstract class Builder {
    protected final List<Integer> player;
    protected final List<Integer> computer;
    protected int ball;
    protected int strike;

    public Builder() {
        this.player = PLAYER.number();
        this.computer = COMPUTER.number();
        this.ball = 0;
        this.strike = 0;
    }


}
