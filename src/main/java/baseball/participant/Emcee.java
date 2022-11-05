package baseball.participant;

import baseball.result.ResultType;

import static baseball.result.ResultType.*;

public class Emcee {

    public void showStartingGuide(String playerName) {
        System.out.println(playerName + "반갑습니다.");
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void showResultMessage(ResultType resultType, int numberOfBall, int numberOfStrike) {
        if (resultType == EXACT_MATCH)
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        else if (resultType == BALL_AND_STRIKE)
            System.out.println(numberOfBall + "볼 " + numberOfStrike + "스트라이크");
        else if (resultType == ONLY_STRIKE)
            System.out.println(numberOfStrike + "스트라이크");
        else if (resultType == ONLY_BALL)
            System.out.println(numberOfBall + "볼");
        else if (resultType == NOTHING)
            System.out.println("낫싱");
    }
}
