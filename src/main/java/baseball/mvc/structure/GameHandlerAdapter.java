package baseball.mvc.structure;

import baseball.mvc.structure.adapter.GameCommandAdapter;
import baseball.mvc.structure.adapter.GamePlayAdapter;
import baseball.mvc.structure.adapter.GameSettingsAdapter;
import java.util.ArrayList;
import java.util.List;

public class GameHandlerAdapter {

    private final List<Adapter> handlerAdapters = new ArrayList<>();

    public GameHandlerAdapter() {
        initHandlerAdapters();
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new GameCommandAdapter());
        handlerAdapters.add(new GamePlayAdapter());
        handlerAdapters.add(new GameSettingsAdapter());
    }

    public Adapter getHandlerAdapter(Object handler) {
        return handlerAdapters.stream()
                .filter(adapter -> adapter.supports(handler))
                .findAny()
                .orElseThrow(NullPointerException::new);
    }
}
