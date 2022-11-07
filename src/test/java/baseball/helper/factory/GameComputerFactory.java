package baseball.helper.factory;

import baseball.domain.game.GameComputer;
import baseball.domain.number.GameNumbers;
import baseball.helper.exception.CannotReflectionException;
import baseball.helper.factory.stub.StubGameNumbers;
import baseball.helper.util.ReflectionFieldUtils;
import java.lang.reflect.Field;

public final class GameComputerFactory {

    private static final String ANSWER_FIELD_NAME = "answer";

    private GameComputerFactory() {
    }

    public static GameComputer createGameComputer(String computerNumberString) {
        GameComputer computer = new GameComputer();
        GameNumbers computerAnswer = new GameNumbers(computerNumberString);

        Field answer = ReflectionFieldUtils.processReflectionField(GameComputer.class, ANSWER_FIELD_NAME);

        try {
            answer.set(computer, computerAnswer);
            return computer;
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }

    public static GameComputer createStubGameComputer(long returnStrike, long returnBall) {
        GameComputer computer = new GameComputer();
        GameNumbers computerAnswer = new StubGameNumbers(returnStrike, returnBall);

        Field answer = ReflectionFieldUtils.processReflectionField(GameComputer.class, ANSWER_FIELD_NAME);

        try {
            answer.set(computer, computerAnswer);
            return computer;
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
