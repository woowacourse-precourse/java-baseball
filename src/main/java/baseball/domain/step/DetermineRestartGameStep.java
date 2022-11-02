package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import baseball.application.io.Reader;
import baseball.application.io.Writer;

public class DetermineRestartGameStep implements Step {

    private static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART_GAME_FLAG = "1";
    private static final String APPLICATION_EXIT_FLAG = "2";

    private static final Step RESTART_GAME_STEP = new GameInitStep();
    private static final Step APPLICATION_EXIT_STEP = new ApplicationExitStep();

    private Step next = APPLICATION_EXIT_STEP;

    @Override
    public void execute(BaseBallGameContext context) {
        Writer writer = context.writer();
        writer.println(RESTART_GAME_MESSAGE);

        Reader reader = context.reader();
        String input = reader.readLine();

        setNextStep(input);
    }

    private void setNextStep(String input) {
        if (input.equals(RESTART_GAME_FLAG)) {
            this.next = RESTART_GAME_STEP;
            return;
        }
        if (input.equals(APPLICATION_EXIT_FLAG)) {
            this.next = APPLICATION_EXIT_STEP;
            return;
        }

        throw new IllegalArgumentException("0 또는 1의 값을 입력하지 않았습니다.");
    }

    @Override
    public Step next() {
        return next;
    }

    @Override
    public boolean executable() {
        return true;
    }
}
