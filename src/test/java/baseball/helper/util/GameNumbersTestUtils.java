package baseball.helper.util;

import baseball.domain.number.GameNumber;
import baseball.domain.number.GameNumbers;
import baseball.helper.exception.CannotReflectionException;
import java.lang.reflect.Field;
import java.util.List;

public final class GameNumbersTestUtils {

    private static final String GAME_NUMBERS_FIELD_NAME = "gameNumbers";

    private GameNumbersTestUtils() {
    }

    @SuppressWarnings("unchecked")
    public static List<GameNumber> getGameNumberList(GameNumbers gameNumbers) {
        Field gameNumberList = ReflectionFieldUtils.processReflectionField(GameNumbers.class, GAME_NUMBERS_FIELD_NAME);

        try {
            return (List<GameNumber>) gameNumberList.get(gameNumbers);
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
