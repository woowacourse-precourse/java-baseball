package baseball;

import java.util.List;

public class Strike {
    private final List<Integer> player;
    private final List<Integer> computer;
    private int count;

    public Strike(List<Integer> player, List<Integer> computer) {
        this.player = player;
        this.computer = computer;
        this.count = 0;
    }

    public int getCount() {
        for (int index = 0; index < 3; index++) {
            if (isStrike(index)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean isStrike(int index) {
        Integer number = player.get(index);
        return number.equals(computer.get(index));
    }
}
