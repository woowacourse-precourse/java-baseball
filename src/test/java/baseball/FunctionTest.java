package baseball;

import static baseball.Application.checkAnswer;
import static baseball.Application.computeProcessing;
import static baseball.Application.startGame;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FunctionTest extends NsTest {

    @Test
    @DisplayName("게임시작 시 해당 문구출력를 출력한다.")
    public void startGameTest() throws Exception {
        //given

        //when
        startGame();
        //then
        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    @DisplayName("게임시작 시 정답초기화를 진행한다.")
    public void startGame_initializeAnswerTest() throws Exception {
        //given

        //when
        startGame();
        //then
        List<Integer> answer = Application.answer;
        assertThat(answer).isNotNull();
        assertThat(answer).hasSize(3);
    }

    @Test
    @DisplayName("정답초기화 시 Answer에 들어오는 값은 1부터9까지이다.")
    public void initializeAnswerTest() throws Exception {
        //given

        //when
        Application.initializeAnswer();
        //then
        List<Integer> answer = Application.answer;
        for (Integer value : answer) {
            assertThat(value).isGreaterThan(0).isLessThan(10);
        }
    }

    @Test
    //@RepeatedTest(100)
    @DisplayName("입력유효성 검사 시 입력받은 값은 숫자이며 해당 자릿수를 가지고있다.")
    public void validateInputTest_1() {
        //given
        int digit = 3;
        String input = "";
        while (input.length() < 3) {
            Random rand = new Random();
            int num = rand.nextInt(9) + 1;
            if (!input.contains(String.valueOf(num))) {
                input = input.concat(String.valueOf(num));
            }
        }
        //when
        String result = Application.validateInput(input, digit);

        //then
        assertThat(result).hasSize(3);
        assertThat(Integer.parseInt(result)).isNotNegative();
    }

    @Test
    @DisplayName("입력유효성 검사 시 같은 수를 입력하면 예외를 발생시킨다.")
    public void validateInputTest_Ex1() {
        //given
        int digit = 3;
        String input = "111";
        //when

        //then
        assertThatThrownBy(() -> Application.validateInput(input, digit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 3자리 수를 입력해주세요.");
    }

    @Test
    @DisplayName("입력유효성 검사 시 0과 숫자 이외의 값을 입력할 수 없다.")
    public void validateInputTest_Ex2() {
        //given
        int digit = 1;
        String inputCase1 = "0";
        String inputCase2 = "s";
        //when

        //then
        assertThatThrownBy(() -> Application.validateInput(inputCase1, digit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 9까지의 숫자만 입력 가능합니다.");

        assertThatThrownBy(() -> Application.validateInput(inputCase2, digit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 9까지의 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("입력유효성 검사 사 해당 자릿수와 다를 수 없다.")
    public void validateInputTest_Ex3() {
        //given
        int digit = 1;
        String input = "123456";
        //when

        //then
        assertThatThrownBy(() -> Application.validateInput(input, digit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(digit + "자릿수를 입력해주세요.");
    }

    @Test
    @DisplayName("프로세싱 후 hintMap에 힌트의 결과값이 저장된다.")
    public void computeProcessingTest() throws Exception {
        //given
        startGame();
        //when
        computeProcessing("123");
        //then
        assertThat(Application.hintMap).isNotNull();
        assertThat(output()).containsAnyOf("볼", "스트라이크", "낫싱");
    }

    @Test
    @DisplayName("정답과 같은 답을 입력할 시 true를 반환한다.")
    public void checkAnswerTest() throws Exception {
        //given
        startGame();
        String input = "";
        for (Integer integer : Application.answer) {
            input = input.concat(integer.toString());
        }
        computeProcessing(input);
        //when
        boolean isCorrect = checkAnswer();
        //then
        assertThat(isCorrect).isEqualTo(true);
    }

    @Override
    protected void runMain() {
//        Application.main(new String[]{});
    }
}