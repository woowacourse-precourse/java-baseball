package baseball.factory;

import baseball.domain.game.GameComputer;
import baseball.domain.number.GameNumbers;
import baseball.factory.fake.FakeGameNumbers;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class GameComputerFactory {

    private static final String ANSWER_FIELD_NAME = "answer";
    private static final int FIELD_INDEX = 0;

    private GameComputerFactory() {
    }

    public static GameComputer createGameComputer(String computerNumberString) {
        GameComputer computer = new GameComputer();
        GameNumbers computerAnswer = new GameNumbers(computerNumberString);

        List<Field> fields = Arrays
            .stream(computer.getClass().getDeclaredFields())
            .filter(field -> field.getName().equals(ANSWER_FIELD_NAME))
            .collect(Collectors.toList());

        Field answer = fields.get(FIELD_INDEX);
        answer.setAccessible(true);

        try {
            answer.set(computer, computerAnswer);
            return computer;
        } catch (Exception e) {
            return new GameComputer();
        }
    }

    public static GameComputer createFakeGameComputer(long returnStrike, long returnBall) {
        GameComputer computer = new GameComputer();
        GameNumbers computerAnswer = new FakeGameNumbers(returnStrike, returnBall);

        List<Field> fields = Arrays
            .stream(computer.getClass().getDeclaredFields())
            .filter(field -> field.getName().equals(ANSWER_FIELD_NAME))
            .collect(Collectors.toList());

        Field answer = fields.get(FIELD_INDEX);
        answer.setAccessible(true);

        try {
            answer.set(computer, computerAnswer);
            return computer;
        } catch (Exception e) {
            return new GameComputer();
        }
    }
}
