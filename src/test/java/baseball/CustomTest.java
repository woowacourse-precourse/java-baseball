package baseball;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomTest {

    @Nested
    public class CustomGenerateNumberTest {

        LocalDateTime now = LocalDateTime.now();
        BaseBallGame bg = new BaseBallGame();

        public CustomGenerateNumberTest() throws NoSuchMethodException {
            Method method = bg.getClass().getDeclaredMethod("generateNumber");
            method.setAccessible(true);
            try {
                method.invoke(bg);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Test
        @DisplayName("생성된 숫자가 없거나 비어있는 리스트인지 확인")
        void generatedNumberIsEmptyOrNull() {
            assertThat(bg.answerNumber).isNotNull().isNotEmpty();
        }

        @Test
        @DisplayName("생성된 숫자가 valid 한지 확인")
        void generatedNumberIsValid() {
            List<Integer> an = bg.answerNumber;
            System.out.println(an);
            for (int i : an) {
                assertThat(an.parallelStream().filter(v -> v == i).count() == 1).isTrue();
            }

        }
    }

    @Nested
    public class CustomStateRulesTest {
        @Test
        @DisplayName("상태전이 규칙이 제대로 적용되었는지 확인 : ON_GAME --> EXIT_GAME")
        void startGameWithCOMPLETE_INITIATION() {
            assertThat(BaseBallGame.rules.get(List.of(BaseBallGame.State.START_GAME.ordinal(), BaseBallGame.Trigger.COMPLETE_INITIATION.ordinal())))
                    .isEqualTo(BaseBallGame.State.ON_GAME);
        }

        @Test
        @DisplayName("상태전이 규칙이 제대로 적용되었는지 확인 : ON_GAME --> EXIT_GAME")
        void onGameWithInvalidUserInput() {
            assertThat(BaseBallGame.rules.get(List.of(BaseBallGame.State.ON_GAME.ordinal(), BaseBallGame.Trigger.INVALID_USER_INPUT.ordinal())))
                    .isEqualTo(BaseBallGame.State.EXIT_GAME);
        }

        @Test
        @DisplayName("상태전이 규칙이 제대로 적용되었는지 확인 : ON_GAME --> FINISH_GAME")
        void onGameWithCorrectAnswer() {
            assertThat(BaseBallGame.rules.get(List.of(BaseBallGame.State.ON_GAME.ordinal(), BaseBallGame.Trigger.CORRECT_ANSWER.ordinal())))
                    .isEqualTo(BaseBallGame.State.FINISH_GAME);
        }

        @Test
        @DisplayName("상태전이 규칙이 제대로 적용되었는지 확인 : ON_GAME --> ON_GAME")
        void onGameWithIncorrectAnswer() {
            assertThat(BaseBallGame.rules.get(List.of(BaseBallGame.State.ON_GAME.ordinal(), BaseBallGame.Trigger.INCORRECT_ANSWER.ordinal())))
                    .isEqualTo(BaseBallGame.State.ON_GAME);
        }

        @Test
        @DisplayName("상태전이 규칙이 제대로 적용되었는지 확인 : FINISH_GAME --> EXIT_GAME")
        void finshGameWithExit() {
            assertThat(BaseBallGame.rules.get(List.of(BaseBallGame.State.FINISH_GAME.ordinal(), BaseBallGame.Trigger.EXIT.ordinal())))
                    .isEqualTo(BaseBallGame.State.EXIT_GAME);
        }

        @Test
        @DisplayName("상태전이 규칙이 제대로 적용되었는지 확인 : FINISH_GAME --> START_GAME")
        void finshGameWithRegame() {
            assertThat(BaseBallGame.rules.get(List.of(BaseBallGame.State.FINISH_GAME.ordinal(), BaseBallGame.Trigger.RE_GAME.ordinal())))
                    .isEqualTo(BaseBallGame.State.START_GAME);
        }

    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("유저의 인풋의 validation check 및 변환을 잘 하는지 검증")
    public class CustomUserInputTest {

        BaseBallGame bg = new BaseBallGame();
        Method inputStringToList;

        public CustomUserInputTest() throws NoSuchMethodException {
            inputStringToList = bg.getClass().getDeclaredMethod("inputStringToList", String.class);
            inputStringToList.setAccessible(true);

        }


        @ParameterizedTest
        @MethodSource("provideArgument1")
        @DisplayName("On_Game 상태에서 valid한 user input을 잘 도출해 내는지 확인")
        void matchUserInputWellWhenOnGame(String userInput, List<Integer> result) throws InvocationTargetException, IllegalAccessException {
            bg.currentState = BaseBallGame.State.ON_GAME;
            assertThat(inputStringToList.invoke(bg, userInput)).isEqualTo(result);
        }

        Stream<Arguments> provideArgument1() {
            return Stream.of(
                    Arguments.arguments("123", List.of(1, 2, 3)),
                    Arguments.arguments("456", List.of(4, 5, 6))
            );
        }

        @ParameterizedTest
        @MethodSource("provideArgument2")
        @DisplayName("On_Game 상태에서 Invalid한 user input을 받고 잘 exception을 발생시키는 지 확인")
        void canCauseExceptionWithInvalidUserInputWhenOnGame(String userInput) {
            bg.currentState = BaseBallGame.State.ON_GAME;
            assertThatThrownBy(() -> {
                inputStringToList.invoke(bg, userInput);
            });
        }

        Stream<String> provideArgument2() {
            return Stream.of(
                    "1234", "45", "6", "s", "123s"
            );
        }


        @ParameterizedTest
        @MethodSource("provideArgument3")
        @DisplayName("Finish_Game 상태에서 valid한 user input을 잘 도출해 내는지 확인")
        void matchUserInputWellWhenFinishGame(String userInput, List<Integer> result) throws InvocationTargetException, IllegalAccessException {
            bg.currentState = BaseBallGame.State.FINISH_GAME;
            assertThat(inputStringToList.invoke(bg, userInput)).isEqualTo(result);
        }

        Stream<Arguments> provideArgument3() {
            return Stream.of(
                    Arguments.arguments("1", List.of(1)),
                    Arguments.arguments("2", List.of(2))
            );
        }

        @ParameterizedTest
        @MethodSource("provideArgument4")
        @DisplayName("Finish_Game 상태에서 Invalid한 user input을 받고 잘 exception을 발생시키는 지 확인")
        void canCauseExceptionWithInvalidUserInputWhenFinishGame(String userInput) {
            bg.currentState = BaseBallGame.State.FINISH_GAME;
            assertThatThrownBy(() -> {
                inputStringToList.invoke(bg, userInput);
            });
        }

        Stream<String> provideArgument4() {
            return Stream.of(
                    "12", "0", "s", "1s"
            );
        }

    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("")
    public class CustomUerInputToScoreTest {

        BaseBallGame bg = new BaseBallGame();
        Method inputStringToList, getResultAndPrint;
        private ByteArrayOutputStream outstream = new ByteArrayOutputStream();
        private PrintStream origin = System.out;

        public CustomUerInputToScoreTest() throws NoSuchMethodException {
            inputStringToList = bg.getClass().getDeclaredMethod("inputStringToList", String.class);
            inputStringToList.setAccessible(true);
            getResultAndPrint = bg.getClass().getDeclaredMethod("getResultOfInput", List.class);
            getResultAndPrint.setAccessible(true);
        }

        @BeforeAll
        public void init() {
            System.setOut(new PrintStream(outstream));
            bg.answerNumber = List.of(1, 2, 3);
        }

        @AfterAll
        public void cleanUp() {
            System.setOut(origin);
        }

        @ParameterizedTest
        @MethodSource("provideArgument")
        @DisplayName("ON_GAME 상태일 때 user input을 받고 옳바른 결과를 출력하는지 확인")
        void userInputCauseCorrectAnswerWhenOnGame(String userInput, String expectedString) throws InvocationTargetException, IllegalAccessException {
            bg.currentState = BaseBallGame.State.ON_GAME;
            getResultAndPrint.invoke(
                    bg, inputStringToList.invoke(bg, userInput));
            String output = outstream.toString();
            assertThat(output).contains(expectedString);
        }

        Stream<Arguments> provideArgument() {
            return Stream.of(
                    Arguments.arguments("123", "3스트라이크"),
                    Arguments.arguments("345", "1볼"),
                    Arguments.arguments("983", "1스트라이크"),
                    Arguments.arguments("913", "1볼 1스트라이크")
            );
        }

    }

}
