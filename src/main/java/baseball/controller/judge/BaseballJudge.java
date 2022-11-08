package baseball.controller.judge;

import baseball.controller.Rule;
import baseball.domain.user.Opponent;
import baseball.domain.user.Player;

import java.util.List;

public class BaseballJudge implements Judge {
    private final String LINES_NOTHING = "낫싱";
    private final String LINES_STRIKE = "스트라이크";
    private final String LINES_BALL = "볼";
    @Override
    public boolean judgement(Player player, Opponent opponent) {
        List<Integer> playerList = player.getNumberList();
        List<Integer> goal = opponent.getGoal();

        int strike = checkStrike(playerList, goal);
        int ball = checkBall(playerList, goal);
        showHint(strike, ball);

        return isCorrectAnswer(strike);
    }

    private boolean isCorrectAnswer(int strike) {
        return strike == Rule.LENGTH.getValue();
    }

    @Override
    public void showHint(final int strike, final int ball) {
        System.out.println(makeHintLines(strike, ball));
    }

    private String makeHintLines(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return LINES_NOTHING;
        }

        StringBuilder builder = new StringBuilder();
        if (ball > 0) {
            builder.append(ball).append(LINES_BALL).append(" ");
        }
        if (strike > 0) {
            builder.append(strike).append(LINES_STRIKE);
        }
        return builder.toString();
    }

    private int checkStrike(final List<Integer> playerList, final List<Integer> goal) {
        int count = 0;
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).equals(goal.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int checkBall(final List<Integer> playerList, final List<Integer> goal) {
        int count = 0;
        for (int i = 0; i < playerList.size(); i++) {
            Integer playerNum = playerList.get(i);
            Integer goalNum = goal.get(i);
            if (goal.contains(playerNum) && !playerNum.equals(goalNum)) {
                count++;
            }
        }
        return count;
    }
}
