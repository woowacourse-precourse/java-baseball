package baseball;

import java.util.List;

public class Ball {
    private final List<Integer> player;
    private final List<Integer> computer;

    public Ball(List<Integer> player, List<Integer> computer) {
        this.player = player;
        this.computer = computer;
    }

    private boolean isBall(Integer number) {
        return computer.contains(number)
                && (computer.indexOf(number) != player.indexOf(number));
    }
}
