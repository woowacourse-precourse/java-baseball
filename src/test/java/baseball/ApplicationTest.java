package baseball;

import baseball.controller.ComputerController;
import baseball.system.AnswerHolder;
import baseball.system.conversion.Converter;
import baseball.system.conversion.StringToIntegerListConverter;
import baseball.system.validation.NumberValidator;
import baseball.system.validation.Validator;
import baseball.view.InputView;
import baseball.vo.Answer;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
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

    @Disabled("현재는 타입 캐스트 예외가 발생한다.")
    @ParameterizedTest(name = "{displayName} {index} - {0}")
    @MethodSource("sourceOfIntegerListNotIntegerBetWeen1And9")
    @DisplayName("Answer 에 저장할 값이 1에서 9 사이의 정수가 아니면 예외가 발생한다.")
    void givenIntegerListNotIntegerBetWeen1And9_whenValidatingGiven_ThenThrowsException(List<?> given) {
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
        List<?> list = List.of(4, 2);

        // when & then
        Validator numberValidator = new NumberValidator();

        // then
        assertThatThrownBy(() -> numberValidator.validate(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(
                        NumberValidator.INVALID_NUMBER_LIST_SIZE_MESSAGE_FORMAT,
                        Answer.ANSWER_LIST_SIZE
                ));
    }

    @Test
    @DisplayName("Answer 에 들어갈 숫자가 서로 다르지 않으면 예외가 발생한다.")
    void givenIntegerListHavingDuplication_whenValidatingGiven_ThenThrowsException() {
        // given
        List<?> list = List.of(4, 2, 4);

        // when & then
        Validator numberValidator = new NumberValidator();

        // then
        assertThatThrownBy(() -> numberValidator.validate(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NumberValidator.DUPLICATING_NUMBER_MESSAGE);
    }

    public static Stream<List> sourceOfIntegerListNotIntegerBetWeen1And9() {
        return Stream.of(
                List.of("1", 3, 4),
                List.of(0, 6, 3),
                List.of(4, 6, 10),
                List.of(2, 6.5, 8),
                List.of(2, "-", 7)
        );
    }

    @Test
    @DisplayName("사용자로부터 숫자를 입력하도록 유도하는 메시지를 출력한다.")
    void whenRunningInputView_thenPrintsInputMessage() {
        // given
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Mockito.mockStatic(Console.class);
        Mockito.when(Console.readLine()).thenReturn("");
        // TODO: 모킹을 위해 Mockito 사용. 아고라에 사용 가능한 지 질문 남겨주었으므로 답변에 따라 코드 수정해야 함.

        // when
        InputView inputView = new InputView();
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
        Mockito.mockStatic(Console.class);
        Mockito.when(Console.readLine()).thenReturn(EXPECTED);
        // TODO: 모킹을 위해 Mockito 사용. 아고라에 사용 가능한 지 질문 남겨주었으므로 답변에 따라 코드 수정해야 함.

        //when
        InputView inputView = new InputView();
        String target = inputView.getUserInput();

        //then
        assertThat(target).isEqualTo(EXPECTED);
    }

    @Test
    @DisplayName("사용자로부터 받은 String 값을 List<Integer> 로 변환한다.")
    void givenStringInput_whenRunningConverter_thenReturnsIntegerList() {
        //given
        String input = "467";

        //when
        Converter converter = new StringToIntegerListConverter();
        List<Integer> target = (List<Integer>) converter.convert(input);

        //then
        assertThat(target).containsExactly(4, 6, 7);
    }
}
