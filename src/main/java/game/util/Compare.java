package game.util;

import game.player.Computer;
import game.player.User;

public class Compare {
    private final BallCount count;

    public Compare() {
        count = new BallCount();
    }

    public boolean isStrikeOut(Computer computer, User user) {
        for (int i = 0; i < 3; ++i) {
            int index = isContain(computer, user.getNumber(i));
            isSameIndex(index, i);
        }
        count.printCount();
        return count.strikeOut();
    }

    private int isContain(Computer computer, int userNumber) {
        if (computer.contains(userNumber)) {
            count.addBall();
            return computer.getIndex(userNumber);
        }
        return -1;
    }

    private void isSameIndex(int index, int i) {
        if (index != -1 && index == i) {
            count.addStrike();
            count.minusBall();
        }
    }
}
