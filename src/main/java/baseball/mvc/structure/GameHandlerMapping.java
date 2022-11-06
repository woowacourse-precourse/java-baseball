package baseball.mvc.structure;

import baseball.mvc.controller.GameCommandController;
import baseball.mvc.controller.GamePlayController;
import baseball.mvc.controller.GameSettingsController;
import baseball.util.GameStatus;
import java.util.EnumMap;
import java.util.Map;

public class GameHandlerMapping {

    private final Map<GameStatus, Object> handlers = new EnumMap<>(GameStatus.class);

    public GameHandlerMapping() {
        initHandlers();
    }

    private void initHandlers() {
        handlers.put(GameStatus.START, new GameSettingsController());
        handlers.put(GameStatus.PLAY, new GamePlayController());
        handlers.put(GameStatus.END, new GameCommandController());
    }

    public Object getHandler(GameStatus gameStatus) {
        return handlers.get(gameStatus);
    }
}
