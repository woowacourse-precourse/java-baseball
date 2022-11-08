package baseball.domain;

import static baseball.global.constants.Constants.QUIT_GAME_FLAG;
import static baseball.global.constants.Constants.Korean.NEW_GAME_OR_QUIT_MESSAGE;
import static baseball.global.constants.Constants.CONTINUE_GAME_FLAG;
import static camp.nextstep.edu.missionutils.Console.*;

import baseball.global.exception.CustomException;

public class BaseballGameStarter {

    public static void playBaseballGame() {
        Computer computer = Computer.of();
        Score score = Score.of();
        BaseballGame baseballGame = BaseballGame.builder()
                .computer(computer)
                .score(score)
                .build();

        String gameFlag;
        do {
            baseballGame.init();
            baseballGame.play();
            printNewGameMessage();
            gameFlag = readLine();
            validateGameFlag(gameFlag);
        } while (gameFlag.equals(CONTINUE_GAME_FLAG));
    }

    private static void validateGameFlag(String gameFlag) {
        if (!gameFlag.equals(CONTINUE_GAME_FLAG) && !gameFlag.equals(QUIT_GAME_FLAG)) {
            throw new IllegalArgumentException(CustomException.INVALID_GAME_FLAG.getMessage());
        }
    }

    private static void printNewGameMessage() {
        System.out.println(NEW_GAME_OR_QUIT_MESSAGE);
    }


    public static void testBaseballGame(String testUserGameFlag) {
        BaseballGame baseballGame = BaseballGame.builder()
                .computer(Computer.of())
                .score(Score.of())
                .build();

        String gameFlag = CONTINUE_GAME_FLAG;
        while (gameFlag.equals(CONTINUE_GAME_FLAG)) {
            baseballGame.init();
            baseballGame.test("123");
            printNewGameMessage();
            gameFlag = testUserGameFlag;
            validateGameFlag(gameFlag);
        }
    }

}
