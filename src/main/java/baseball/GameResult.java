package baseball;

import java.util.Map;

public class GameResult {
    public static boolean resultCase(Map<String, Integer> result) {
        if (result.get("strike") == 0 && result.get("ball") == 0) {
            System.out.println("낫싱");
            return false;
        } else if (result.get("strike") == 0) {
            System.out.println(result.get("ball") + "볼");
            return false;
        } else if (result.get("strike") == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (result.get("ball") == 0) {
            System.out.println(result.get("strike") + "스트라이크");
            return false;
        } else {
            System.out.println(result.get("strike") + "스트라이크 " + result.get("ball") + "볼");
            return false;
        }

    }
}
