package baseball.mvc.structure;

import baseball.util.GameStatus;

public class GameHandlerManager {

    private final GameHandlerAdapter handlerAdapter = new GameHandlerAdapter();
    private final GameHandlerMapping handlerMapping = new GameHandlerMapping();

    public Adapter getHandlerAdapter(Object handler) {
        return handlerAdapter.getHandlerAdapter(handler);
    }

    public Object getHandler(GameStatus gameStatus) {
        return handlerMapping.getHandler(gameStatus);
    }
}
