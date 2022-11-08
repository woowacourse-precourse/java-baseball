package domain;

import static org.junit.jupiter.api.Assertions.*;

import domain.GameResultJudgement;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GameResultJudgementTest {

    private GameResultJudgement judge;

    @BeforeEach
    void setUp() {
        judge = new GameResultJudgement(3);
    }

    void assertStrike(String input, String answer, int expected) {
        assertEquals(expected, judge.judgeStrikeBallNothing(input, answer).get(0));
    }

    void assertBall(String input, String answer, int expected) {
        assertEquals(expected, judge.judgeStrikeBallNothing(input, answer).get(1));
    }

    void assertNothing(String input, String answer, int expected) {
        assertEquals(expected, judge.judgeStrikeBallNothing(input, answer).get(2));
    }

    @Order(1)
    @DisplayName("스트라이크 3 확인")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @MethodSource("paramsForJudgeStrikeCount3")
    void JudgeStrikeCount3(String input, String answer, int expected) {
        assertStrike(input, answer, expected);
    }
    private static Stream<Arguments> paramsForJudgeStrikeCount3() {
        return Stream.of(
            Arguments.of("123", "123", 3),
            Arguments.of("456", "456", 3),
            Arguments.of("789", "789", 3)
        );
    }

    @Order(2)
    @DisplayName("스트라이크 2 확인")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @MethodSource("paramsForJudgeStrikeCount2")
    void JudgeStrikeCount2(String input, String answer, int expected) {
        assertStrike(input, answer, expected);
    }
    private static Stream<Arguments> paramsForJudgeStrikeCount2() {
        return Stream.of(
            Arguments.of("123", "124", 2),
            Arguments.of("456", "457", 2),
            Arguments.of("789", "289", 2)
        );
    }

    @Order(3)
    @DisplayName("스트라이크 1 확인")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @MethodSource("paramsForJudgeStrikeCount1")
    void JudgeStrikeCount1(String input, String answer, int expected) {
        assertStrike(input, answer, expected);
    }
    private static Stream<Arguments> paramsForJudgeStrikeCount1() {
        return Stream.of(
            Arguments.of("123", "524", 1),
            Arguments.of("456", "957", 1),
            Arguments.of("789", "762", 1)
        );
    }

    @Order(4)
    @DisplayName("볼 3 확인")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @MethodSource("paramsForJudgeBallCount3")
    void JudgeBallCount3(String input, String answer, int expected) {
        assertBall(input, answer, expected);
    }
    private static Stream<Arguments> paramsForJudgeBallCount3() {
        return Stream.of(
            Arguments.of("123", "312", 3),
            Arguments.of("456", "645", 3),
            Arguments.of("789", "978", 3)
        );
    }

    @Order(5)
    @DisplayName("볼 2 확인")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @MethodSource("paramsForJudgeBallCount2")
    void JudgeBallCount2(String input, String answer, int expected) {
        assertBall(input, answer, expected);
    }
    private static Stream<Arguments> paramsForJudgeBallCount2() {
        return Stream.of(
            Arguments.of("123", "412", 2),
            Arguments.of("456", "245", 2),
            Arguments.of("789", "178", 2)
        );
    }

    @Order(6)
    @DisplayName("볼 1 확인")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @MethodSource("paramsForJudgeBallCount1")
    void JudgeBallCount1(String input, String answer, int expected) {
        assertBall(input, answer, expected);
    }
    private static Stream<Arguments> paramsForJudgeBallCount1() {
        return Stream.of(
            Arguments.of("123", "981", 1),
            Arguments.of("456", "785", 1),
            Arguments.of("789", "217", 1)
        );
    }

    @Order(7)
    @DisplayName("볼 0 확인")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @MethodSource("paramsForJudgeBallCount0")
    void JudgeBallCount0(String input, String answer, int expected) {
        assertBall(input, answer, expected);
    }
    private static Stream<Arguments> paramsForJudgeBallCount0() {
        return Stream.of(
            Arguments.of("123", "123", 0),
            Arguments.of("789", "762", 0),
            Arguments.of("789", "289", 0)
        );
    }

    @Order(8)
    @DisplayName("낫싱 확인")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @MethodSource("paramsForJudgeNothingCount")
    void JudgeNothingCount(String input, String answer, int expected) {
        assertNothing(input, answer, expected);
    }
    private static Stream<Arguments> paramsForJudgeNothingCount() {
        return Stream.of(
            Arguments.of("123", "123", 0),
            Arguments.of("789", "762", 0),
            Arguments.of("789", "289", 0)
        );
    }
}