package baseball.model;

import java.util.List;

public class Judge {

    private List<Integer> playerNumbers;
    private List<Integer> answer;

    public Judge(Computer computer, Player player) {
        this.playerNumbers = player.getPlayerNumbers();
        this.answer = computer.getAnswer();
    }

    public Boolean isGameSuccess() {
        return  (playerNumbers.equals(answer));
    }
}