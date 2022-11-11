package baseball.game.generator;

import baseball.game.model.TargetNumber;

public interface NumberGenerator {

    TargetNumber createTargetNumber(int length);
}
