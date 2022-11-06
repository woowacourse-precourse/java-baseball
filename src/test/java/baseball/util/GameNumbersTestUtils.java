package baseball.util;

import baseball.domain.number.GameNumber;
import baseball.domain.number.GameNumbers;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class GameNumbersTestUtils {

    private static final String GAME_NUMBERS_FIELD_NAME = "gameNumbers";
    private static final int FIELD_INDEX = 0;

    private GameNumbersTestUtils() {
    }

    public static List<GameNumber> getGameNumberList(GameNumbers gameNumbers) {
        List<Field> fields = Arrays
            .stream(gameNumbers.getClass().getDeclaredFields())
            .filter(field -> field.getName().equals(GAME_NUMBERS_FIELD_NAME))
            .collect(Collectors.toList());

        Field gameNumberList = fields.get(FIELD_INDEX);

        try {
            gameNumberList.setAccessible(true);
            return (List<GameNumber>) gameNumberList.get(gameNumbers);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
