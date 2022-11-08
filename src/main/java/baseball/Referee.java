package baseball;

import java.util.List;

public class Referee {
    private Computer computer;
    private BaseballScore baseballScore;

    public Referee(Computer computer) {
        this.computer = computer;
    }

    public void compareComputerWith(List<Integer> playerInput) {
        baseballScore = new BaseballScore();

        for (int i = 0; i < computer.getNumbers().size(); i++) {
            if (computer.getNumbers().get(i).equals(playerInput.get(i))) {
                baseballScore.increaseStrike();
            } else if (computer.getNumbers().contains(playerInput.get(i))) {
                baseballScore.increaseBall();
            }
        }
    }

    public int getStrikeCount() {
        return baseballScore.getStrike();
    }

    public int getBallCount() {
        return baseballScore.getBall();
    }
}