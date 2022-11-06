package baseball.model;

import java.util.List;
import java.util.Objects;

public class Referee {
    private static final int START_INDEX = 0;
    private static final int MAX_BALLS_SIZE = 3;

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
        return result;
    }

    public void printResult(Result result) {
        if (result.hasNothing()) {
            System.out.println("낫싱");
            return;
        }
        if (result.hasBall()) {
            System.out.print(result.getBallCount() + "볼 ");
        }

        if(!result.hasStrike()) {
            System.out.println();
        }

        if (result.hasStrike()) {
            System.out.println(result.getStrikeCount() + "스트라이크");
        }

        if (result.isGameOver()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
