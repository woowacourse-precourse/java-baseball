package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    public void 사용자입력() {
        User user = new User();
        System.setIn(new ByteArrayInputStream("123".getBytes(StandardCharsets.UTF_8)));
        String input = user.getConsoleInput();
        assertThat("123").isEqualTo(input);
    }

    @Test
    public void 사용자입력_실패_케이스1() {
        User user = new User();
        System.setIn(new ByteArrayInputStream("13a".getBytes(StandardCharsets.UTF_8)));
        assertThatThrownBy(() -> user.getConsoleInput()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사용자입력_실패_케이스2() {
        User user = new User();
        System.setIn(new ByteArrayInputStream("133".getBytes(StandardCharsets.UTF_8)));
        assertThatThrownBy(() -> user.mappingUserInputToBaseBallNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사용자입력_실패_케이스3() {
        User user = new User();
        System.setIn(new ByteArrayInputStream("1234".getBytes(StandardCharsets.UTF_8)));
        assertThatThrownBy(() -> user.mappingUserInputToBaseBallNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 컴퓨터와숫자비교1() {
        User user = new User();
        System.setIn(new ByteArrayInputStream("123".getBytes(StandardCharsets.UTF_8)));
        user.register(genMockObserver(List.of(1, 2, 3)));
        user.mappingUserInputToBaseBallNumber();

        List<Hint> hintList = user.compareToComputer();
        List<Hint> result = List.of(Hint.STRIKE, Hint.STRIKE, Hint.STRIKE);

        assertThat(hintList).isEqualTo(result);
    }

    @Test
    public void 컴퓨터와숫자비교2() {
        User user = new User();
        System.setIn(new ByteArrayInputStream("231".getBytes(StandardCharsets.UTF_8)));
        user.register(genMockObserver(List.of(1, 2, 3)));
        user.mappingUserInputToBaseBallNumber();

        List<Hint> hintList = user.compareToComputer();
        List<Hint> result = List.of(Hint.BALL, Hint.BALL, Hint.BALL);

        assertThat(hintList).isEqualTo(result);
    }

    @Test
    public void 컴퓨터와숫자비교3() {
        User user = new User();
        System.setIn(new ByteArrayInputStream("456".getBytes(StandardCharsets.UTF_8)));
        user.register(genMockObserver(List.of(1, 2, 3)));
        user.mappingUserInputToBaseBallNumber();

        List<Hint> hintList = user.compareToComputer();
        List<Hint> result = List.of(Hint.NOTHING, Hint.NOTHING, Hint.NOTHING);

        assertThat(hintList).isEqualTo(result);
    }

    @Test
    public void 컴퓨터와숫자비교4() {
        User user = new User();
        System.setIn(new ByteArrayInputStream("235".getBytes(StandardCharsets.UTF_8)));
        user.register(genMockObserver(List.of(1, 2, 3)));
        user.mappingUserInputToBaseBallNumber();

        List<Hint> hintList = user.compareToComputer();
        List<Hint> result = List.of(Hint.BALL, Hint.BALL, Hint.NOTHING);

        assertThat(hintList).isEqualTo(result);
    }

    private Observer genMockObserver(List<Integer> observerList) {
        return new Observer() {
            List<Integer> integerList = new ArrayList<>(observerList);

            @Override
            public List<Hint> compare(List<Integer> list) {
                List<Integer> number = integerList;
                List<Hint> hintList = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    hintList.add(genHint(list, number, i, 0));
                }
                return hintList;
            }

            private Hint genHint(List<Integer> input, List<Integer> number, int inputIndex, int numberIndex) {
                if (isaBoolean(numberIndex, BaseBallNumber.BASE_BALL_NUMBER_MAX_SIZE)) return Hint.NOTHING;

                if (isaBoolean(input.get(inputIndex), number.get(numberIndex))) {
                    return judgeByStrikeOrBall(inputIndex, numberIndex);
                }

                return genHint(input, number, inputIndex, numberIndex + 1);
            }

            private boolean isaBoolean(Integer integer, Integer integer2) {
                return integer == integer2;
            }

            private Hint judgeByStrikeOrBall(int inputIndex, int numberIndex) {
                if (isaBoolean(inputIndex, numberIndex)) {
                    return Hint.STRIKE;
                }

                return Hint.BALL;
            }
        };
    }
}
