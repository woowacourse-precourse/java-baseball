package baseball.service;

import baseball.Ball;
import baseball.Result;

import java.util.List;

public class RefereeService {
    public Result generateResult(List<Ball> computerBalls, List<Ball> playerBalls) {
        Result result = new Result();
        for (int i = 0; i < playerBalls.size(); i++) {
            Ball computerBall = computerBalls.get(i);
            Ball playerBall = playerBalls.get(i);

            if (computerBall.equals(playerBall)) {
                result.increaseStrikeCount();
                continue;
            }
            if (computerBalls.contains(playerBall)) {
                result.increaseBallCount();
            }
        }
        return result;
    }

    public void printResult(Result result) {
        if (result.hasNothing()) {
            System.out.println("낫싱");
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
