//package baseball.testcase;
//
//import baseball.controller.GameController;
//import camp.nextstep.edu.missionutils.Randoms;
//import camp.nextstep.edu.missionutils.test.NsTest;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.MockedStatic;
//
//import java.io.ByteArrayInputStream;
//import java.util.NoSuchElementException;
//
//import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
//import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.mockito.Mockito.*;
//
//public class NBallBaseGameTest extends NsTest {
//
//    @Test
//    void 게임종료_후_재시작() {
//        assertRandomNumberInRangeTest(
//                () -> {
//                    runNBall(5, "12346", "21435", "12345", "1", "43210", "98765", "2");
//                    assertThat(output()).contains("4스트라이크", "1볼 4스트라이크", "5스트라이크", "낫싱", "게임 종료");
//                },
//                1, 2, 3, 4, 5, 9, 8, 7, 6, 5
//        );
//    }
//
//    @Test
//    @DisplayName("5Ball Game일 경우 5글자 이하의 입력을 넣으면 에러가 발생한다.")
//    void 예외_테스트_요구한_숫자보다_적은_숫자를_넣으면_에러가_발생한다() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runNBallException(5, "1234"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }
//
//    @Test
//    @DisplayName("5Ball Game일 경우 5글자 이상의 입력을 넣으면 에러가 발생한다.")
//    void 예외_테스트_요구한_숫자보다_많은_숫자를_넣으면_에러가_발생한다() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runNBallException(5, "123456"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }
//
//    @Test
//    @DisplayName("숫자가 아닌 값이 섞여 있다면 에러가 발생한다")
//    void 예외_테스트_숫자가_아닌_문자가_섞여_있으면_에러가_발생한다() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runNBallException(5, "hello"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }
//
//    @Test
//    @DisplayName("게임 진행 의사를 물었을 때 1,2 외의 숫자를 넣으면 에러가 발생한다")
//    void 게임_진행은_숫자_1과_2만_허용한다() {
//        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
//        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
//                .thenReturn(1, 2, 3, 4, 5);
//
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runNBallException(5, "12345", "this is not 1 or 2"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }
//
//
//    private void runNBall(int i, final String... args) {
//        final byte[] buf = String.join("\n", args).getBytes();
//        System.setIn(new ByteArrayInputStream(buf));
//        GameController gameController = new GameController(i);
//        gameController.playRecurringGame();
//    }
//
//    private void runNBallException(int i, String... args) {
//        try {
//            runNBall(i, args);
//        } catch (final NoSuchElementException ignore) {
//        }
//    }
//
//    @Override
//    protected void runMain() {
//
//    }
//
//}
