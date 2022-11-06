package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {


    public String printResult(BaseballGameResultDto baseballResultDto) {
        int ball = baseballResultDto.getBall();
        int strike = baseballResultDto.getStrike();

        StringBuilder sb = new StringBuilder();

        if (ball > 0) {
            sb.append(ball + "볼" + " ");
        }

        if (strike > 0) {
            sb.append(strike + "스트라이크" + " ");
        }

        if (sb.length() == 0) {
            return "낫싱";
        }
        return sb.toString();
    }
}
