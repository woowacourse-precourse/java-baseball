package baseball;

import camp.nextstep.edu.missionutils.Console;

public class StopGame {
    public static int isStop() {
        int res;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String stopFlag = Console.readLine();

        if (stopFlag.equals("1")) {
            res = 0;
        } else if (stopFlag.equals("2")) {
            res = 1;
        } else {
            throw new IllegalArgumentException();
        }

        return res;
    }
}
