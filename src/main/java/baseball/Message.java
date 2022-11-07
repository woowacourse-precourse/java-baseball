package baseball;

import java.util.List;

public class Message {
    public String start() {
        return "숫자 야구 게임을 시작합니다.";
    }

    public String requestThreeNumbers() {
        return "숫자를 입력해주세요 : ";
    }

    public String success() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public String requestNewOrStop() {
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }

    String result(List<Integer> result) {
        int ball = result.get(0);
        int strike = result.get(1);
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (ball == 0 && strike > 0) {
            return strike + "스트라이크";
        }
        if (ball > 0 && strike == 0) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
