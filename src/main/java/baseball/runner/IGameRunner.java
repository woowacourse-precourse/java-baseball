package baseball.runner;

import baseball.engine.PlayState;

public interface IGameRunner {
    void init();

    PlayState run();
}
