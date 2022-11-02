package baseball.application.context;

import baseball.application.config.BaseBallGameConfig;
import baseball.application.io.Reader;
import baseball.application.io.Writer;
import baseball.domain.computer.Computer;
import baseball.domain.number.BaseBallGameNumbers;
import baseball.domain.player.Player;

public class BaseBallGameContext {

    private final Writer writer;
    private final Reader reader;

    private Player player;
    private Computer computer;

    public BaseBallGameContext(BaseBallGameConfig config) {
        this.writer = config.writer();
        this.reader = config.reader();
    }

    public Writer writer() {
        return writer;
    }

    public Reader reader() {
        return reader;
    }

    public void init() {

    }

    public void changePlayerNumbers(BaseBallGameNumbers baseBallGameNumbers) {

    }
}
