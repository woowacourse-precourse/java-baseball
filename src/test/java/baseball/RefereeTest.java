package baseball;

import static baseball.utils.Constant.BALL_INDEX;
import static baseball.utils.Constant.STRIKE_INDEX;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.domain.Referee;
import baseball.utils.ValidationNumber;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RefereeTest {
    private Referee referee;
    private ValidationNumber validationNumber;

    @BeforeEach
    void before() {
        referee = new Referee();
        validationNumber = new ValidationNumber();
    }

    @ParameterizedTest
    @ValueSource(strings = {"246", "178", "935", "135" })
    void strikeTest(String input) {
        List<Integer> defenceNumber = List.of(1, 3, 5);
        try {
            Field field = referee.getClass().getDeclaredField("defenceNumber");
            field.setAccessible(true);
            field.set(referee, defenceNumber);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        List<Integer> inputList = validationNumber.checkTotalAndConvertIntegerList(input);
        referee.setOffenceNumber(inputList);

        List<Integer> result = referee.getBallAndStrikeCount();

        List<Integer> resultList = List.of(0, 1, 2, 3);
        assertThat(result.get(STRIKE_INDEX)).isIn(resultList);
    }

    @ParameterizedTest
    @ValueSource(strings = {"246", "981", "185", "351" })
    void ballTest(String input) {
        List<Integer> defenceNumber = List.of(1, 3, 5);
        try {
            Field field = referee.getClass().getDeclaredField("defenceNumber");
            field.setAccessible(true);
            field.set(referee, defenceNumber);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        List<Integer> inputList = validationNumber.checkTotalAndConvertIntegerList(input);
        referee.setOffenceNumber(inputList);

        List<Integer> result = referee.getBallAndStrikeCount();

        List<Integer> resultList = List.of(0, 1, 2, 3);
        assertThat(result.get(BALL_INDEX)).isIn(resultList);
    }
}
