package baseball.model;

import java.util.List;

import static baseball.model.Judge.Result.*;

public class Judge {

    private List<Integer> playerNumbers;
    private List<Integer> answer;

    enum Result {
        BALL, STRIKE, NOTHING;
    }

    public Judge() {

    }

    public Judge(Computer computer, Player player) {
        this.playerNumbers = player.getPlayerNumbers();
        this.answer = computer.getAnswer();
    }

    public Boolean isGameSuccess() {
        return  (playerNumbers.equals(answer));
    }

    public Score countScoreOfStrikeAndBall() {
        Score score = new Score();
        for (int i = 0; i< answer.size(); i++ ) {
            Result result = isBallOrStrike(i);
            if (result.equals(BALL)) score.countBall();
            if (result.equals(STRIKE)) score.countStrike();
        }
        return score;
    }

    public Result isBallOrStrike(int index) {
        Integer target = playerNumbers.get(index);

        int findIndex = answer.indexOf(target);
        if (findIndex == index) return STRIKE;
        if (findIndex != -1) return BALL;
        return NOTHING;
    }

    // 테스트용 set 메소드, 실제 개발에는 사용X
    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
}
