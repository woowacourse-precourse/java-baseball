package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import baseball.application.io.Writer;
import baseball.domain.comparator.Comparator;
import baseball.domain.computer.Computer;
import baseball.domain.player.Player;
import baseball.domain.result.CompareResult;

public class GameProgressStep implements Step {

    @Override
    public void execute(BaseBallGameContext context) {
        Player player = context.player();
        Computer computer = context.computer();
        Comparator comparator = context.comparator();

        CompareResult compareResult =
                comparator.compare(player.baseBallGameNumbers(), computer.baseBallGameNumbers());

    }

    @Override
    public Step next() {
        return null;
    }

    @Override
    public boolean executable() {
        return false;
    }
}
