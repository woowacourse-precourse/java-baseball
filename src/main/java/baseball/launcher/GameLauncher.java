package baseball.launcher;

import baseball.common.log.Log;
import baseball.engine.PlayState;
import baseball.runner.IGameRunner;


public class GameLauncher {

    private GameLauncher() {

    }

    public static void run(GameType gameType) {
        try {
            IGameRunner gameRunner = gameType.getRunner();
            gameRunner.init();

            while (gameRunner.run() == PlayState.RUN) {

            }

        } catch (IllegalArgumentException e) {
            Log.getLogger().error(e, e.getMessage());
            throw new IllegalArgumentException(e);
        } catch (Exception e) {
            Log.getLogger().error(e, e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
