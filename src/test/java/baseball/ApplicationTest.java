package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Nested
    class ComputerTest {
        Computer computer = new Computer();
        @Test
        void 컴퓨터_숫자_3자리인지_테스트() {
            //given
            List<Integer> numberList = computer.getRandomNumber();
            //then
            assertThat(numberList.size()).isEqualTo(3);
        }

        @Test
        void 컴퓨터_숫자_중복없는지_테스트() {
            //given
            List<Integer> numberList = computer.getRandomNumber();
            //when
            Set<Integer> numberSet = new HashSet<>(numberList);
            //then
            assertThat(numberSet.size()).isEqualTo(3);
        }

        @Test
        void 컴퓨터_첫번째_자리수를_올바르게_가져오는지_테스트() {
            //given
            List<Integer> numberList = computer.getRandomNumber();
            //when
            int firstNumber = computer.getFirstRandomNumber();
            //then
            assertThat(firstNumber).isEqualTo(numberList.get(0));
        }

        @Test
        void 컴퓨터_두번째_자리수를_올바르게_가져오는지_테스트() {
            //given
            List<Integer> numberList = computer.getRandomNumber();
            //when
            int secondNumber = computer.getSecondRandomNumber();
            //then
            assertThat(secondNumber).isEqualTo(numberList.get(1));
        }

        @Test
        void 컴퓨터_세번째_자리수를_올바르게_가져오는지_테스트() {
            //given
            List<Integer> numberList = computer.getRandomNumber();
            //when
            int thirdNumber = computer.getThirdRandomNumber();
            //then
            assertThat(thirdNumber).isEqualTo(numberList.get(2));
        }
    }

    @Nested
    class BaseBallGameTest {
        BaseBallGame baseBallGame = new BaseBallGame();
        @Test
        void 유저_숫자_입력_테스트() {
            //given
            String userNumber = "123";
            InputStream in = new ByteArrayInputStream(userNumber.getBytes());
            System.setIn(in);
            //when
            baseBallGame.inputUserNumber();
            //then
            assertThat(baseBallGame.getUserNumber()).isEqualTo(userNumber);
        }

        @Test
        void 유저_숫자가_컴퓨터_숫자와_일치_테스트() {
            //given
            List<Integer> randomNumber = baseBallGame.getComputer().getRandomNumber();
            String strRandomNumber = randomNumber.toString().replaceAll("[^0-9]","");
            InputStream in = new ByteArrayInputStream(strRandomNumber.getBytes());
            System.setIn(in);
            //when
            baseBallGame.inputUserNumber();
            int isEqual = baseBallGame.isEqualToComputerNumber();
            //then
            assertThat(isEqual).isEqualTo(1);
        }

        @Test
        void 스트라이크_개수_확인() {
            //given
            List<Integer> randomNumber = baseBallGame.getComputer().getRandomNumber();
            String strRandomNumber = randomNumber.toString().replaceAll("[^0-9]","");
            InputStream in = new ByteArrayInputStream(strRandomNumber.getBytes());
            System.setIn(in);
            //when
            baseBallGame.inputUserNumber();
            baseBallGame.countStrikeCount();
            //then
            assertThat(baseBallGame.getStrikeCount()).isEqualTo(3);
        }

        @Test
        void 볼_개수_확인() {
            //given
            List<Integer> randomNumber = baseBallGame.getComputer().getRandomNumber();
            String strRandomNumber = randomNumber.toString().replaceAll("[^0-9]","");
            InputStream in = new ByteArrayInputStream(strRandomNumber.getBytes());
            System.setIn(in);
            //when
            baseBallGame.inputUserNumber();
            baseBallGame.countBallCount();
            //then
            assertThat(baseBallGame.getBallCount()).isEqualTo(0);
        }

        @Test
        void 재시작_토큰_예외처리() {
            //given
            String testToken = "0";
            InputStream in = new ByteArrayInputStream(testToken.getBytes());
            System.setIn(in);
            //then
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                baseBallGame.setRestartToken();
            });
        }

        @Test
        void 유저_입력_길이_테스트() {
            //given
            String userNumber = "1234";
            InputStream in = new ByteArrayInputStream(userNumber.getBytes());
            System.setIn(in);
            //then
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                baseBallGame.inputUserNumber();
            });
        }

        @Test
        void 유저_입력_숫자_테스트() {
            //given
            String userNumber = "1a4";
            InputStream in = new ByteArrayInputStream(userNumber.getBytes());
            System.setIn(in);
            //then
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                baseBallGame.inputUserNumber();
            });
        }

        @Test
        void 유저_입력_중복_테스트() {
            //given
            String userNumber = "112";
            InputStream in = new ByteArrayInputStream(userNumber.getBytes());
            System.setIn(in);
            //then
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                baseBallGame.inputUserNumber();
            });
        }

        @Test
        void 유저_입력_범위_테스트() {
            //given
            String userNumber = "103";
            InputStream in = new ByteArrayInputStream(userNumber.getBytes());
            System.setIn(in);
            //then
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                baseBallGame.inputUserNumber();
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
