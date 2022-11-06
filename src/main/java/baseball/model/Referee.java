package baseball.model;

import baseball.model.dto.Balls;
import baseball.model.dto.Result;

import java.util.List;
import java.util.Objects;

public class Referee {
    private static final int START_INDEX = 0;
    private static final int MAX_BALLS_SIZE = 3;
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public Result doJudge(Balls computerBalls, Balls playerBalls) {
        Result result = new Result();

        List<Integer> computerValues = computerBalls.getValues();
        List<Integer> playerValues = playerBalls.getValues();

        for (int i = START_INDEX; i < MAX_BALLS_SIZE; i++) {
            if (Objects.equals(computerValues.get(i), playerValues.get(i))) {
                result.increaseStrikeCount();
                continue;
            }
            if (computerValues.contains(playerValues.get(i))) {
                result.increaseBallCount();
            }
        }
        printResult(result);
        return result;
    }

    private void printResult(Result result) {
        StringBuilder resultBuilder = new StringBuilder();
        if (result.hasNothing()) {
            resultBuilder.append(NOTHING_MESSAGE);
        }
        if (result.hasBall()) {
            resultBuilder.append(result.getBallCount())
                         .append(BALL_MESSAGE);
        }
        if (result.hasStrike()) {
            resultBuilder.append(result.getStrikeCount())
                         .append(STRIKE_MESSAGE);
        }
        if (result.isGameOver()) {
            resultBuilder.append("\n" + GAME_OVER_MESSAGE)
                         .append("\n" + GAME_RESTART_MESSAGE);
        }
        System.out.println(resultBuilder);
    }
}
