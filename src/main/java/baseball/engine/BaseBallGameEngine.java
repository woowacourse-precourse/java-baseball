package baseball.engine;

import baseball.model.BallStatus;
import baseball.model.Numbers;

public interface BaseBallGameEngine {
    BallStatus countBall(Numbers answer, Numbers userNumbers);

    Numbers parseToNumbers(String number);
}
