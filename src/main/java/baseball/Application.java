package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println(getGuideMessage(null));
        while (true) {

        }

    }

    public static String getGuideMessage(String userNumber) {
        if (userNumber == null) {
            return "숫자 야구 게임을 시작합니다.";
        } else {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

        }
    }

}
