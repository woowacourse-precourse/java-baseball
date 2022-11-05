package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        while (true) {
            int userNumber = -1;
            printMessage(userNumber);
        }

    }

    public static void printMessage(int userNumber) {
        if (userNumber == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
        } else {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
