package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameAgain {
    public boolean isAgain() {
        boolean runAgain = true;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String userInput = Console.readLine();

        if (userInput == "1") {
            runAgain = true;
        } else if (userInput == "2") {
            runAgain = false;
        }

        return runAgain;
    }
}
