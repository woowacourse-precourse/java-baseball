package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.Retry;

import static baseball.domain.Retry.RETRY_NUM;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        } while (wantAgain());
    }

    private static boolean wantAgain() {
        Retry retry = new Retry(readLine());

        return retry.getRetryNum().equals(RETRY_NUM);
    }
}
