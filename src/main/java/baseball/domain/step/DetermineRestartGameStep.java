package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import baseball.application.io.Reader;
import baseball.application.io.Writer;

public class DetermineRestartGameStep implements Step {

    private static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    @Override
    public void execute(BaseBallGameContext context) {
        Writer writer = context.writer();
        writer.println(RESTART_GAME_MESSAGE);

        Reader reader = context.reader();
        String input = reader.readLine();

    }

    @Override
    public Step next() {
        return null;
    }

    @Override
    public boolean executable() {
        return true;
    }
}
