package baseball;

import java.util.Map;

public class GameResult {
    public static boolean resultCase(Map<String, Integer> result) {
        int ball = result.get("ball") ;
        int strike = result.get("strike");
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        }else if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return false;
        }  else if (strike == 0) {
            System.out.println(ball + "볼");
            return false;
        } else {
            System.out.println(ball + "볼 "+strike + "스트라이크 ");
            return false;
        }

    }
}
