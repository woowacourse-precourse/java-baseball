package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Referee {
    public static final int LENGTH_LIMIT = 3;
    private List<Integer> computerList;
    private List<Integer> playerList;
    private int strikes = 0;
    private int balls = 0;

    public void printHint() {
        String hint;
        if (balls > 0 && strikes > 0) {
            hint = balls + "볼 " + strikes + "스트라이크";
        } else if (balls > 0) {
            hint = balls + "볼";
        } else if (strikes > 0) {
            hint = strikes + "스트라이크";
        } else {
            hint = "낫싱";
        }
        System.out.println(hint);
    }

    public void updateHint() {
        updateStrikes();
        updateBalls();
    }

    private void updateStrikes() {
        strikes = 0;
        for (int i = 0; i < LENGTH_LIMIT; i++) {
            if (playerList.get(i) == computerList.get(i)) {
                strikes++;
            }
        }
    }

    private void updateBalls() {
        Set<Integer> set = new HashSet<>();
        set.addAll(computerList);
        set.addAll(playerList);
        balls = LENGTH_LIMIT * 2 - set.size() - strikes;
    }

    public void setComputerList(List<Integer> computerList) {
        this.computerList = computerList;
    }

    public void setPlayerList(List<Integer> playerList) {
        this.playerList = playerList;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
