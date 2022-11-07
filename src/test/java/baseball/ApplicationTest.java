package baseball;

import baseball.controller.ComputerController;
import baseball.dto.Score;
import baseball.system.conversion.*;
import baseball.system.exception.ConverterNotFoundException;
import baseball.system.exception.ValidatorNotFoundException;
import baseball.system.holder.AnswerHolder;
import baseball.system.holder.ConverterHolder;
import baseball.system.holder.ValidatorHolder;
import baseball.system.validation.NumberValidator;
import baseball.system.validation.StringToIntegerListConversionValidator;
import baseball.system.validation.Validator;
import baseball.system.voter.BaseballVoter;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Answer;
import baseball.vo.Restart;
import baseball.vo.UserNumber;
import camp.nextstep.edu.missionutils.test.NsTest;
import mocking.MockInputView;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    @BeforeEach
    void setup() {
        ValidatorHolder.setValidators(List.of(
                new NumberValidator(),
                new StringToIntegerListConversionValidator()
        ));

        ConverterHolder.setConverters(List.of(
                new StringToRestartConverter(),
                new StringToIntegerListConverter(),
                new IntegerListToUserNumberConverter(),
                new ScoreToMessageConverter()
        ));
    }

    @AfterEach
    void after() {
        ValidatorHolder.clearHolder();
        ConverterHolder.clearHolder();
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Nested
    @DisplayName("ComputerController 테스트")
    class ComputerControllerTest {
        @Test
        @DisplayName("컴퓨터가 정답 숫자를 생성한다.")
        void whenDoCreatingAnswer_thenSavingAnswerIntoAnswerHolder() {
            // when
            ComputerController computerController = new ComputerController();
            computerController.createAnswer();

            // then
            System.out.println("AnswerHolder.getAnswer() = " + AnswerHolder.getAnswer());
            assertThat(AnswerHolder.getAnswer()).isNotNull();
        }

    }

    @Nested
    @DisplayName("NumberValidator 테스트")
    class NumberValidatorTest {
        @ParameterizedTest(name = "{displayName} - {0}")
        @MethodSource("baseball.ApplicationTest#sourceOfIntegerListNotBetWeen1And9")
        @DisplayName("Answer 에 저장할 값이 1에서 9 사이의 정수가 아니면 예외가 발생한다.")
        void givenIntegerListNotBetWeen1And9_whenValidatingGiven_ThenThrowsException(List<Integer> given) {
            // when & then
            Validator numberValidator = new NumberValidator();

            // then
            assertThatThrownBy(() -> numberValidator.validate(given))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format(
                            NumberValidator.INVALID_NUMBER_RANGE_MESSAGE_FORMAT,
                            Answer.MIN_ANSWER_VALUE,
                            Answer.MAX_ANSWER_VALUE
                    ));
        }

        @Test
        @DisplayName("Answer 에 들어갈 숫자 개수가 3개가 아니면 예외가 발생한다.")
        void givenIntegerListSizeNot3_whenValidatingGiven_ThenThrowsException() {
            // given
            List<Integer> list = List.of(4, 2);

            // when & then
            Validator numberValidator = new NumberValidator();

            // then
            assertThatThrownBy(() -> numberValidator.validate(list))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format(
                            NumberValidator.INVALID_NUMBER_LIST_SIZE_MESSAGE_FORMAT,
                            Answer.ANSWER_SIZE
                    ));
        }

        @Test
        @DisplayName("Answer 에 들어갈 숫자가 서로 다르지 않으면 예외가 발생한다.")
        void givenIntegerListHavingDuplication_whenValidatingGiven_ThenThrowsException() {
            // given
            List<Integer> list = List.of(4, 2, 4);

            // when & then
            Validator numberValidator = new NumberValidator();

            // then
            assertThatThrownBy(() -> numberValidator.validate(list))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NumberValidator.DUPLICATING_NUMBER_MESSAGE);
        }
    }

    public static Stream<List<Integer>> sourceOfIntegerListNotBetWeen1And9() {
        return Stream.of(
                List.of(0, 6, 3),
                List.of(4, 6, 10)
        );
    }

    @Nested
    @DisplayName("InputView 테스트")
    class InputViewTest {
        @Test
        @DisplayName("게임 시작을 알리는 메시지를 출력한다.")
        void whenRunningInputView_thenPrintsGameStartMessage() {
            //given
            ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));
            OutputView outputView = new OutputView();

            //when
            outputView.printStartMessage();

            //then
            assertThat(outputStreamCaptor.toString().trim())
                    .isEqualTo(OutputView.GAME_START_MESSAGE.trim());
        }

        @Test
        @DisplayName("사용자로부터 숫자를 입력하도록 유도하는 메시지를 출력한다.")
        void whenRunningInputView_thenPrintsInputMessage() {
            // given
            ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));
            InputView inputView = new MockInputView();

            // when
            inputView.getUserInput();

            // then
            assertThat(outputStreamCaptor.toString().trim())
                    .isEqualTo(InputView.NUMBER_INPUT_NUDGE_MESSAGE.trim());
        }

        @Test
        @DisplayName("사용자로부터 숫자를 입력받는다.")
        void whenRunningInputView_thenReturnsUserInput() {
            String EXPECTED = "468";

            //given
            MockInputView inputView = new MockInputView();
            inputView.setMockMessage(EXPECTED);

            //when
            String target = inputView.getUserInput();

            //then
            assertThat(target).isEqualTo(EXPECTED);
        }

        @Test
        @DisplayName("게임의 재시작 여부를 묻는 메시지가 출력된다.")
        void whenRunningInputAskingRestartingInput_thenPrintsMessage() {
            //given
            ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));
            InputView inputView = new MockInputView();

            //when
            inputView.getRestartingInput();

            //then
            assertThat(outputStreamCaptor.toString().trim())
                    .isEqualTo(InputView.ASKING_RESTART_MESSAGE.trim());
        }
    }

    @Nested
    @DisplayName("StringToIntegerListConverter 테스트")
    class StringToIntegerListConverterTest {
        @Test
        @DisplayName("사용자로부터 받은 String 값을 List<Integer> 로 변환한다.")
        void givenStringInput_whenRunningConverter_thenReturnsIntegerList() {
            //given
            String input = "467";

            //when
            Converter<String, List<Integer>> converter = new StringToIntegerListConverter();
            List<Integer> target = converter.convert(input);

            //then
            assertThat(target).containsExactly(4, 6, 7);
        }

        @ParameterizedTest(name = "{displayName} - {0}")
        @MethodSource("baseball.ApplicationTest#sourceOfStringIncludingNotNaturalNumber")
        @DisplayName("사용자로부터 받은 입력값이 자연수로 이루어지지 않은 경우 예외가 발생한다.")
        void givenIntegerListIncludingNotNaturalNumber_whenValidatingGiven_ThenThrowsException(String given) {
            // when
            Validator validator = new StringToIntegerListConversionValidator();
            assertThatThrownBy(() -> validator.validate(given))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(StringToIntegerListConversionValidator.VALUE_NOT_NATURAL_NUMBER_MESSAGE);
        }
    }

    public static Stream<String> sourceOfStringIncludingNotNaturalNumber() {
        return Stream.of(
                "일34",
                "26.6",
                "2-7"
        );
    }

    @Nested
    @DisplayName("BaseballVoter 테스트")
    class BaseballVoterTest {
        @ParameterizedTest(name = "{index} - 정답 456에 대해 {0} 입력 시 알맞는 결과를 반환한다.")
        @MethodSource("baseball.ApplicationTest#sourceOfUserInputAndBaseballResult")
        void givenAnswerAndUserInput_whenPlayingBaseball_thenReturnsResult(UserNumber input, Score score) {
            Answer ANSWER = Answer.of(List.of(4, 5, 6));

            // given
            AnswerHolder.setAnswer(ANSWER);

            // when
            BaseballVoter baseballVoter = new BaseballVoter();
            Score target = baseballVoter.vote(input);

            // then
            assertThat(target).isEqualTo(score);
        }
    }

    private static Stream<Arguments> sourceOfUserInputAndBaseballResult() {
        return Stream.of(
                Arguments.of(UserNumber.of(List.of(4, 5, 6)), Score.makeNewScoreWith(3, 0)),
                Arguments.of(UserNumber.of(List.of(7, 5, 1)), Score.makeNewScoreWith(1, 0)),
                Arguments.of(UserNumber.of(List.of(6, 2, 4)), Score.makeNewScoreWith(0, 2))
        );
    }

    @Nested
    @DisplayName("OutputView 테스트")
    class OutputViewTest {
        @ParameterizedTest(name = "{index} - 주어진 점수에 대해 알맞는 결과 메시지를 출력한다. - {0}")
        @MethodSource("baseball.ApplicationTest#sourceOfScores")
        void givenScore_whenRunningOutputView_thenPrintsResult(Score given, String resultMessage) {
            // given
            ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));

            //when
            OutputView outputView = new OutputView();
            outputView.printResult(given);

            //then
            assertThat(outputStreamCaptor.toString().trim())
                    .isEqualTo(resultMessage);
        }

        @Test
        @DisplayName("게임의 정답을 맞추었을 때 승리자의 메시지가 출력된다.")
        void whenRunningOutputViewPrintingWinnerMessage_thenPrintsWinnersMessage() {
            // given
            ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));

            //when
            OutputView outputView = new OutputView();
            outputView.printWinnerMessage();

            //then
            assertThat(outputStreamCaptor.toString().trim())
                    .isEqualTo(String.format(OutputView.WINNING_MESSAGE_FORMAT, Answer.ANSWER_SIZE).trim());
        }
    }

    public static Stream<Arguments> sourceOfScores() {
        return Stream.of(
                Arguments.of(Score.makeNewScoreWith(0, 0),
                        ScoreToMessageConverter.NOTHING_MESSAGE.trim()),
                Arguments.of(Score.makeNewScoreWith(0, 1),
                        String.format(ScoreToMessageConverter.BALL_MESSAGE_FORMAT, 1).trim()),
                Arguments.of(Score.makeNewScoreWith(2, 1),
                        String.format(ScoreToMessageConverter.BALL_MESSAGE_FORMAT, 1)
                                .concat(String.format(ScoreToMessageConverter.STRIKE_MESSAGE_FORMAT, 2).trim())
                ),
                Arguments.of(Score.makeNewScoreWith(3, 0),
                        String.format(ScoreToMessageConverter.STRIKE_MESSAGE_FORMAT, 3).trim())
        );
    }

    @Nested
    @DisplayName("ConverterHolder 테스트")
    class ConverterHolderTest {
        @Test
        @DisplayName("List<Integer> 를 UserNumber 로 변환하는 요청을 하면 IntegerListToUserNumberConverter 가 동작한다.")
        void givenIntegerListToUserNumber_whenRunningConverterHolder_thenRunsIntegerListToUserNumberConverter() {
            // given
            List<Integer> target = List.of(5, 7, 3);
            Class<UserNumber> to = UserNumber.class;

            // supports 통과 여부
            assertThat(new IntegerListToUserNumberConverter().supports(target, to)).isTrue();
            assertThat(new ScoreToMessageConverter().supports(target, to)).isFalse();
            assertThat(new StringToIntegerListConverter().supports(target, to)).isFalse();
            assertThat(new StringToRestartConverter().supports(target, to)).isFalse();

            // 변환 성공케이스
            Object result = ConverterHolder.convert(target, to);
            assertThat(result.getClass()).isEqualTo(to);
            assertThat((UserNumber) result).isEqualTo(UserNumber.of(target));

            // 변환 실패케이스
            assertThatThrownBy(() -> ConverterHolder.convert(List.of(0, 4, 5), to))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format(NumberValidator.INVALID_NUMBER_RANGE_MESSAGE_FORMAT,
                            Answer.MIN_ANSWER_VALUE, Answer.MAX_ANSWER_VALUE));
        }

        @Test
        @DisplayName("Score 를 String 으로 변환하는 요청을 하면 ScoreToMessageConverter 가 동작한다.")
        void givenScoreToString_whenRunningConverterHolder_thenRunsStringToMessageConverter() {
            // given
            Score target = Score.makeNewScoreWith(2, 1);
            Class<String> to = String.class;

            // supports 통과 여부
            assertThat(new IntegerListToUserNumberConverter().supports(target, to)).isFalse();
            assertThat(new ScoreToMessageConverter().supports(target, to)).isTrue();
            assertThat(new StringToIntegerListConverter().supports(target, to)).isFalse();
            assertThat(new StringToRestartConverter().supports(target, to)).isFalse();

            // 변환 성공케이스
            Object result = ConverterHolder.convert(target, to);
            assertThat(result.getClass()).isEqualTo(to);
            assertThat((String) result).isEqualTo(String.format(
                    "%s%s",
                    String.format(ScoreToMessageConverter.BALL_MESSAGE_FORMAT, 1),
                    String.format(ScoreToMessageConverter.STRIKE_MESSAGE_FORMAT, 2)
            ));
        }

        @Test
        @DisplayName("String 을 List<Integer> 로 변환하는 요청을 하면 StringToIntegerListConverter 가 동작한다.")
        void givenStringToIntegerList_whenRunningConverterHolder_thenRunsStringToIntegerListConverter() {
            // given
            String target = "345";
            Class<List> to = List.class;

            // supports 통과 여부
            assertThat(new IntegerListToUserNumberConverter().supports(target, to)).isFalse();
            assertThat(new ScoreToMessageConverter().supports(target, to)).isFalse();
            assertThat(new StringToIntegerListConverter().supports(target, to)).isTrue();
            assertThat(new StringToRestartConverter().supports(target, to)).isFalse();

            // 변환 성공케이스
            Object result = ConverterHolder.convert(target, to);
            assertThat(result).isInstanceOf(List.class);
            assertThat((List<Integer>) result).isEqualTo(List.of(3, 4, 5));

            // 변환 실패케이스
            assertThatThrownBy(() -> ConverterHolder.convert("6-4", to))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(StringToIntegerListConversionValidator.VALUE_NOT_NATURAL_NUMBER_MESSAGE);
        }

        @Test
        @DisplayName("String 을 Restart 로 변환하는 요청을 하면 StringToRestartConverter 가 동작한다.")
        void givenStringToRestart_whenRunningConverterHolder_thenRunsStringToRestartConverter() {
            // given
            String target = Restart.EXIT.getValue();
            Class<Restart> to = Restart.class;

            // supports 통과 여부
            assertThat(new IntegerListToUserNumberConverter().supports(target, to)).isFalse();
            assertThat(new ScoreToMessageConverter().supports(target, to)).isFalse();
            assertThat(new StringToIntegerListConverter().supports(target, to)).isFalse();
            assertThat(new StringToRestartConverter().supports(target, to)).isTrue();

            // 변환 성공케이스
            Object result = ConverterHolder.convert(target, to);
            assertThat(result).isInstanceOf(Restart.class);
            assertThat((Restart) result).isEqualTo(Restart.EXIT);

            // 변환 실패케이스
            assertThatThrownBy(() -> ConverterHolder.convert("3", to))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(StringToRestartConverter.INVALID_INPUT_VALUE_MESSAGE);
        }

        @Test
        @DisplayName("어떤 Converter 에도 맞지 않는 값이 주어지면 예외가 발생한다.")
        void givenDisMatchingToAnyConverters_whenRunningConverterHolder_thenThrowsException() {
            // given
            int target = 345;
            Class<Restart> to = Restart.class;

            assertThat(new IntegerListToUserNumberConverter().supports(target, to)).isFalse();
            assertThat(new ScoreToMessageConverter().supports(target, to)).isFalse();
            assertThat(new StringToIntegerListConverter().supports(target, to)).isFalse();
            assertThat(new StringToRestartConverter().supports(target, to)).isFalse();

            // 변환 시도시
            assertThatThrownBy(() -> ConverterHolder.convert(target, to))
                    .isInstanceOf(ConverterNotFoundException.class);
        }
    }

    @Nested
    @DisplayName("ValidatorHolder 테스트")
    class ValidatorTest {
        @Test
        @DisplayName("List<Integer>가 UserNumber 또는 Answer 객체를 만들기에 적합한 지 검증 요청을 하면 NumberValidator가 동작한다.")
        void givenIntegerListValidatingForUserNumberOrAnswer_whenRunningValidatorHolder_thenRunsNumberValidator() {
            // given
            List<Integer> target = List.of(1, 3, 4);
            Class<UserNumber> to = UserNumber.class;

            // supports 통과 여부
            assertThat(new NumberValidator().supports(target, to)).isTrue();
            assertThat(new StringToIntegerListConversionValidator().supports(target, to)).isFalse();

            // 검증 통과케이스
            assertThatCode(() -> ValidatorHolder.validate(target, to))
                    .doesNotThrowAnyException();

            // 검증 실패케이스
            assertThatThrownBy(() -> ValidatorHolder.validate(List.of(4, 5, 4), to))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NumberValidator.DUPLICATING_NUMBER_MESSAGE);
        }

        @Test
        @DisplayName("String 이 List<Integer> 로 변환하기에 적합한 지 검증 요청을 하면 StringToIntegerListConversionValidator 가 동작한다.")
        void givenStringValidatingForIntegerList_whenRunningValidatorHolder_thenRunsStringToIntegerListConversionValidator() {
            // given
            String target = "345";
            Class<List> to = List.class;

            // supports 통과 여부
            assertThat(new NumberValidator().supports(target, to)).isFalse();
            assertThat(new StringToIntegerListConversionValidator().supports(target, to)).isTrue();

            // 검증 통과케이스
            assertThatCode(() -> ValidatorHolder.validate(target, to))
                    .doesNotThrowAnyException();

            // 검증 실패케이스
            assertThatThrownBy(() -> ValidatorHolder.validate("6-7", to))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(StringToIntegerListConversionValidator.VALUE_NOT_NATURAL_NUMBER_MESSAGE);
        }

        @Test
        @DisplayName("어떤 Validator 에도 맞지 않는 값이 주어지면 예외가 발생한다.")
        void givenDisMatchingToAnyValidators_whenRunningValidatorHolder_thenThrowsException() {
            // given
            int target = 345;
            Class<List> to = List.class;

            assertThat(new NumberValidator().supports(target, to)).isFalse();
            assertThat(new StringToIntegerListConversionValidator().supports(target, to)).isFalse();

            // 변환 시도시
            assertThatThrownBy(() -> ValidatorHolder.validate(target, to))
                    .isInstanceOf(ValidatorNotFoundException.class);
        }
    }
}
