package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("숫자야구게임 관리")
class ServerTest {

    @Nested
    @DisplayName("숫자야구게임의 흐름과 순서 관리 기능")
    class RunTest extends NsTest {

        @Test
        void 게임을_한번만_하는_시나리오에서_정상동작한다() {
            assertRandomNumberInRangeTest(
                () -> {
                    run("197", "179", "2");
                    String expected = List.of(
                            "숫자 야구 게임을 시작합니다.",
                            "숫자를 입력해주세요 : 2볼 1스트라이크",
                            "숫자를 입력해주세요 : 3스트라이크",
                            "3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
                        ).
                        stream().collect(Collectors.joining("\n"));
                    assertThat(output()).isEqualTo(expected);
                },
                1, 7, 9
            );
        }

        @Test
        void 게임종료하고_한번_더_하는_시나리오에서_정상동작한다() {
            assertRandomNumberInRangeTest(
                () -> {
                    run("197", "179", "1", "317", "123", "2");
                    String expected = List.of(
                            "숫자 야구 게임을 시작합니다.",
                            "숫자를 입력해주세요 : 2볼 1스트라이크",
                            "숫자를 입력해주세요 : 3스트라이크",
                            "3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.",
                            "숫자를 입력해주세요 : 2볼",
                            "숫자를 입력해주세요 : 3스트라이크",
                            "3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
                        ).
                        stream().collect(Collectors.joining("\n"));
                    assertThat(output()).isEqualTo(expected);
                },
                1, 7, 9, 1, 2, 3
            );
        }

        @Test
        void 플레이어_게임숫자_입력_시_예외처리는_정상동작한다() {
            assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                    .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Override
        protected void runMain() {
            new Server().run();
        }
    }

    @Nested
    @DisplayName("1~9의 서로 다른 숫자 3개로 이뤄진 숫자 생성 기능")
    class MakeNewGameNumberTest {

        @Test
        void 게임숫자는_3자리의_숫자입니다() {
            List<Integer> gameNumberList = new Server().makeNewGameNumber();
            int expectedGameNumberList = 3;
            int actualGameNumberList = gameNumberList.size();
            assertThat(actualGameNumberList).isEqualTo(expectedGameNumberList);
        }

        @Test
        void 게임숫자는_서로_다른_숫자로_구성되어_있습니다() {
            List<Integer> gameNumberList = new Server().makeNewGameNumber();
            boolean expectedIsDuplicated = false;
            boolean actualIsDuplicated = false;

            while (gameNumberList.size() != 0) {
                int degreeNumber = gameNumberList.remove(0);
                actualIsDuplicated |= gameNumberList.contains(degreeNumber);
            }
            assertThat(actualIsDuplicated).isEqualTo(expectedIsDuplicated);
        }
    }

    @Nested
    @DisplayName("플레이어 입력숫자를 게임숫자로 결과 판정 기능")
    class JudgeInputNumberTest {

        @Test
        void 플레이어_숫자_판정결과는_2스트라이크가_맞습니다() {
            List<Integer> gameNumberList = List.of(2, 3, 9);
            int playerInputNumber = 234;
            int expectCountStrikes = 2, expectCountBalls = 0;

            JudgedResultDto actualJudgedResultDto =
                new Server()
                    .judgeInputNumber(playerInputNumber, gameNumberList);

            boolean expectedResult = true;
            boolean actualResult = false;
            if (actualJudgedResultDto.countBalls == expectCountBalls
                && actualJudgedResultDto.countStrikes == expectCountStrikes) {
                actualResult = true;
            }

            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        void 플레이어_숫자_판정결과는_3스트라이크가_맞습니다() {
            List<Integer> gameNumberList = List.of(4, 7, 9);
            int playerInputNumber = 479;
            int expectCountStrikes = 3, expectCountBalls = 0;

            JudgedResultDto actualJudgedResultDto =
                new Server()
                    .judgeInputNumber(playerInputNumber, gameNumberList);

            boolean expectedResult = true;
            boolean actualResult = false;
            if (actualJudgedResultDto.countBalls == expectCountBalls
                && actualJudgedResultDto.countStrikes == expectCountStrikes) {
                actualResult = true;
            }

            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        void 플레이어_숫자_판정결과는_낫싱가_맞습니다() {
            List<Integer> gameNumberList = List.of(2, 3, 9);
            int playerInputNumber = 186;
            int expectCountStrikes = 0, expectCountBalls = 0;

            JudgedResultDto actualJudgedResultDto =
                new Server()
                    .judgeInputNumber(playerInputNumber, gameNumberList);

            boolean expectedResult = true;
            boolean actualResult = false;
            if (actualJudgedResultDto.countBalls == expectCountBalls
                && actualJudgedResultDto.countStrikes == expectCountStrikes) {
                actualResult = true;
            }

            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        void 플레이어_숫자_판정결과는_3볼이_맞습니다() {
            List<Integer> gameNumberList = List.of(2, 3, 9);
            int playerInputNumber = 392;
            int expectCountStrikes = 0, expectCountBalls = 3;

            JudgedResultDto actualJudgedResultDto =
                new Server()
                    .judgeInputNumber(playerInputNumber, gameNumberList);

            boolean expectedResult = true;
            boolean actualResult = false;
            if (actualJudgedResultDto.countBalls == expectCountBalls
                && actualJudgedResultDto.countStrikes == expectCountStrikes) {
                actualResult = true;
            }

            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        void 플레이어_숫자_판정결과는_2볼_1스트라이크가_맞습니다() {
            List<Integer> gameNumberList = List.of(2, 3, 9);
            int playerInputNumber = 329;
            int expectCountStrikes = 1, expectCountBalls = 2;

            JudgedResultDto actualJudgedResultDto =
                new Server()
                    .judgeInputNumber(playerInputNumber, gameNumberList);

            boolean expectedResult = true;
            boolean actualResult = false;
            if (actualJudgedResultDto.countBalls == expectCountBalls
                && actualJudgedResultDto.countStrikes == expectCountStrikes) {
                actualResult = true;
            }

            assertThat(actualResult).isEqualTo(expectedResult);
        }
    }

}