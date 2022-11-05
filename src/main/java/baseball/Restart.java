package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Restart {

    public static void answer(BaseballGame baseballGame) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        final String START = "1";
        final String END = "2";

        String restartType = Console.readLine();
        Exception.Check(restartType, 1);

        if (restartType.equals(START)) {
            baseballGame.gameStart();
        } else if (!restartType.equals(START) || !restartType.equals(END)) {
            answer(baseballGame);
        }
    }

}
