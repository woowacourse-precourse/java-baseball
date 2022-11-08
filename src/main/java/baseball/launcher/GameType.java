package baseball.launcher;

import baseball.engine.BaseballEngine;
import baseball.runner.BaseballRunner;
import baseball.runner.IGameRunner;
import baseball.viewer.BaseballViewer;

public enum GameType {
    BASEBALL {
        @Override
        public IGameRunner getRunner() {
            BaseballViewer viewer = new BaseballViewer();
            BaseballEngine engine = new BaseballEngine();

            return new BaseballRunner(viewer, engine);
        }
    };

    abstract IGameRunner getRunner();
}
