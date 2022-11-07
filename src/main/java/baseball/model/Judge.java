package baseball.model;

import java.util.List;

public class Judge {

    private List<Integer> playerNumbers;
    private List<Integer> answer;

    private int ball;
    private int strike;

    public Judge() {

    }

    public Judge(Computer computer, Player player) {
        this.playerNumbers = player.getPlayerNumbers();
        this.answer = computer.getAnswer();
    }

    public Boolean isGameSuccess() {
        return  (playerNumbers.equals(answer));
    }

    public Hint getScoreHint() {
        if (ball == 0 && strike == 0) return Hint.NOTHING;
        if (ball == 0) return Hint.ONLY_STRIKE;
        if (strike == 0) return Hint.ONLY_BALL;
        return Hint.BALL_AND_STRIKE;
    }

    public void countAllScoreOfStrikeAndBall() {
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

    // 테스트용 set 메소드, 실제 개발에는 사용X
    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
