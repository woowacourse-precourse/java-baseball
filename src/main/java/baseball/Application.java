package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static String inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return readLine();
    }

    public static void main(String[] args) {
        printGameStart();
    }
}
