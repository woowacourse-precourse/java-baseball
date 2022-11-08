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

        return reflectionGameComputer(computer, computerAnswer);
    }

    public static GameComputer createStubGameComputer(long returnStrike, long returnBall) {
        GameComputer computer = new GameComputer();
        GameNumbers stubComputerAnswer = new StubGameNumbers(returnStrike, returnBall);

        return reflectionGameComputer(computer, stubComputerAnswer);
    }

    private static GameComputer reflectionGameComputer(GameComputer computer, GameNumbers computerAnswer) {
        Field answer = ReflectionFieldUtils.processReflectionField(GameComputer.class, ANSWER_FIELD_NAME);

        try {
            answer.set(computer, computerAnswer);
            return computer;
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
