package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.controller.BaseballController;
import baseball.service.OperatorService;
import baseball.vo.enumtype.GameNumberInclusive;
import baseball.vo.enumtype.GameRule;
import baseball.vo.enumtype.UserInterfaceMessage;
import baseball.vo.enumtype.ValidationMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


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

    @Test
    void 랜덤_숫자_세자리_생성_테스트() {
        // give
        final BaseballController baseballController = BaseballController.getInstance();
        baseballController.createNewBaseballGameNumberList();
        // when
        final List<Integer> baseballGameNumberList = baseballController.getComputerBaseballGameNumberList();
        // then
        assertThat(baseballGameNumberList.size()).isEqualTo(GameRule.GAME_NUMBER_LEN.getValue());
    }

    @Test
    void 게임시작_시_생성된_숫자의_범위_테스트() {
        // give
        final BaseballController baseballController = BaseballController.getInstance();
        baseballController.createNewBaseballGameNumberList();
        // when
        final List<Integer> baseballGameNumberList = baseballController.getComputerBaseballGameNumberList();
        // then
        assertThat(baseballGameNumberList.stream().allMatch(gameNumber ->
                gameNumber >= GameNumberInclusive.START.getValue() && gameNumber <= GameNumberInclusive.END.getValue()));
    }

    @Test
    void 게임시작_시_생성된_숫자의_중복_테스트() {
        // give
        final BaseballController baseballController = BaseballController.getInstance();
        baseballController.createNewBaseballGameNumberList();
        final List<Integer> baseballGameNumberList = baseballController.getComputerBaseballGameNumberList();
        // when
        final Set<Integer> baseballGameNumberSet = new HashSet<>(baseballGameNumberList);
        // then
        assertThat(baseballGameNumberList.size()).isEqualTo(baseballGameNumberSet.size());
    }

    @Test
    void UserInterfaceMessage_메시지_확인_테스트() {
        // give
        final String gameStartMessage =
                "야구게임에 오신 것을 환영합니다.\n야구게임은 숫자 3개를 입력받습니다.\n만약 종료를 원하시면 2를 입력하세요 ";
        // when
        final String gameStartMessageEnum = UserInterfaceMessage.GAME_INFO.getValue();
        // then
        assertThat(gameStartMessage).isEqualTo(gameStartMessageEnum);
    }

    @Test
    void ValidationMessage_메시지_확인_테스트() {
        // give
        final String properTypeMessage = "바르게 입력되었습니다.";
        // when
        final String properTypeMessageEnum = ValidationMessage.PROPER_TYPE.getValue();
        // then
        assertThat(properTypeMessage).isEqualTo(properTypeMessageEnum);
    }

    @Test
    void 사용자의_null값_입력_예외_테스트() {
        final String userInput = null;
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.NULL_TYPE.getValue());
    }

    @Test
    void 사용자의_empty_string값_입력_예외_테스트() {
        final String userInput = "";
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.EMPTY_TYPE.getValue());
    }

    @Test
    void 사용자의_0_입력_예외_테스트() {
        final String userInput = "0";
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.ZERO_TYPE.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = "abc")
    void 숫자로_변환될_수_없는_값_입력_예외_테스트(final String userInput) {
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.NOT_NUMBER.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = "13")
    void 사용자의_3자리_미만_입력_예외_테스트(final String userInput) {
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.UNDER_THREE.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = "1234")
    void 사용자의_3자리_초과_입력_예외_테스트(final String userInput) {
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.OVER_THREE.getValue());
    }


    @ParameterizedTest
    @ValueSource(strings = "223")
    void 사용자의_게임_중복_숫자값_입력_예외_테스트(final String userInput) {
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.NOT_DUPLICATE_NUMBER.getValue());
    }

    @Test
    void 사용자의_게임_입력값_저장_테스트() {
        // give
        final String userInput = "234";
        final List<Integer> tempList = Arrays.asList(1, 2, 3);
        OperatorService operatorService = OperatorService.getInstance();
        // when
        operatorService.operateGame(tempList, userInput);
        // then
        assertThat(operatorService.generateGameNumberList(userInput))
                .isEqualTo(operatorService.getPlayerGameNumberList());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
