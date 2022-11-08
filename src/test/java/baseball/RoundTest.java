package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RoundTest {

    private static Computer computer;
    private static int computerNumbers;
    private static int computerNumber1;
    private static int computerNumber2;
    private static int computerNumber3;
    private static final List<Integer> notIncludeNumber = new ArrayList<>();

    private static Round round;

    @BeforeAll
    static void beforeAll() {
        computer = Computer.getComputer();
        computer.pickRandomNumbers();
        //컴퓨터가 선택한 숫자
        computerNumbers = 0;
        computerNumber1 = computer.findComputerNumber(0).getNumber();
        computerNumbers += computerNumber1 * ((int) Math.pow(10, 2));
        computerNumber2 = computer.findComputerNumber(1).getNumber();
        computerNumbers += computerNumber2 * ((int) Math.pow(10, 1));
        computerNumber3 = computer.findComputerNumber(2).getNumber();
        computerNumbers += computerNumber3 * ((int) Math.pow(10, 0));
        //컴퓨터가 선택하지 않은 숫자 리스트
        for (int number = 1; number <= 9; number++) {
            if ((number != computerNumber1)
                    && (number != computerNumber2)
                    && (number != computerNumber3)) {
                notIncludeNumber.add(number);
            }
        }
    }

    @BeforeEach
    void beforeEach() {
        Computer computer = Computer.getComputer();
        User user = User.getUser();
        round = Round.getRound(computer, user);
    }

    @DisplayName(value = "라운드 시작 시 입력 숫자 Numbers에 담기는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123"})
    void roundInputTest(String input) throws Exception {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        round.startNewRound();

        Field field = Round.class.getDeclaredField("user");
        field.setAccessible(true);
        User user = (User) field.get(round);

        for (int i = 0; i < 3; i++) {
            assertThat(user.findUserNumber(i).getNumber())
                    .isEqualTo((i + 1));
        }
    }

    @DisplayName("라운드 시작 시 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1234"})
    void roundInputExceptionTest(String input) throws Exception {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> round.startNewRound())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("점수 테스트")
    @ParameterizedTest
    @MethodSource("createNumbers")
    void roundScoreTest(String input, int count, Hint hint) throws Exception {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        round.startNewRound();

        Field field = Round.class.getDeclaredField("hints");
        field.setAccessible(true);
        Hints hints = (Hints) field.get(round);

        assertThat(hints.findHintCount(hint)).isEqualTo(count);
    }

    @DisplayName("점수 출력 테스트")
    @ParameterizedTest
    @MethodSource("createNumbers")
    void roundPrintTest(String input, int count, Hint hint) throws Exception {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        round.startNewRound();

        Field field = Round.class.getDeclaredField("hints");
        field.setAccessible(true);
        Hints hints = (Hints) field.get(round);

        if (hint == Hint.NOTHING) {
            assertThat(out.toString().trim())
                    .isEqualTo(("숫자를 입력해주세요 : " + hint.getValue()).trim());
        }
        if (hint != Hint.NOTHING) {
            assertThat(out.toString().trim())
                    .isEqualTo(("숫자를 입력해주세요 : " + count + hint.getValue()).trim());
        }
    }

    private static Stream<Arguments> createNumbers() {
        // 스트라이크 숫자 생성
        String oneStrike = "" + computerNumber1 + notIncludeNumber.get(0) + notIncludeNumber.get(1);
        String twoStrike = "" + computerNumber1 + computerNumber2 + notIncludeNumber.get(0);
        String threeStrike = "" + computerNumber1 + computerNumber2 + computerNumber3;
        // 볼 숫자 생성
        String oneBall = "" + computerNumber2 + notIncludeNumber.get(0) + notIncludeNumber.get(1);
        String twoBall = "" + computerNumber2 + computerNumber3 + notIncludeNumber.get(0);
        String threeBall = "" + computerNumber2 + computerNumber3 + computerNumber1;
        // 낫싱 숫자 생성
        String threeNothing = "" + notIncludeNumber.get(0) + notIncludeNumber.get(1) + notIncludeNumber.get(2);

        return Stream.of(
                Arguments.of(oneStrike, 1, Hint.STRIKE),
                Arguments.of(twoStrike, 2, Hint.STRIKE),
                Arguments.of(threeStrike, 3, Hint.STRIKE),
                Arguments.of(oneBall, 1, Hint.BALL),
                Arguments.of(twoBall, 2, Hint.BALL),
                Arguments.of(threeBall, 3, Hint.BALL),
                Arguments.of(threeNothing, 3, Hint.NOTHING)
        );
    }

}
