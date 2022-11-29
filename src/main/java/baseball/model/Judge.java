package baseball.model;

import java.util.List;

public class Judge {

    private List<Integer> playerNumbers;
    private List<Integer> answer;

    private int ball;
    private int strike;

    public Judge(Computer computer, Player player) {
        this.playerNumbers = player.getPlayerNumbers();
        this.answer = computer.getAnswer();
    }

    public Boolean isGameSuccess() {
        return  (playerNumbers.equals(answer));
    }

    public String getHintMessage() {
        Hint findHint = Hint.findHint(ball, strike);
        return findHint.printHintMessage(ball, strike);
    }

    public void countScore() {
        for (int i = 0; i< answer.size(); i++ ) {
            countBallOrStrike(i);
        }
    }

    public void countBallOrStrike(int index) {
        Integer target = playerNumbers.get(index);

        int findIndex = answer.indexOf(target);
        if (findIndex == index) strike++;
        else if (findIndex != -1) ball++;
    }
}
