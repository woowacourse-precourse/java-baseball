package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
    void computerMakeRandomNumber() {
        //given
        Computer computer = new Computer();
        int cnt = 0;

        //when
        List<Integer> computerNumbers = computer.makeComputerNumbers();

        for (int i = 1; i < computerNumbers.size(); i++) {
            if (Objects.equals(computerNumbers.get(i - 1), computerNumbers.get(i))) {
                cnt++;
            }
        }

        //then
        Assertions.assertThat(cnt).isEqualTo(0);
        Assertions.assertThat(computerNumbers.size()).isEqualTo(3);
    }

    @Test
    void validUserInputOverLap() {
        //given
        User user = new User();
        String userInput = "111";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user.validUserInput(userInput);
        });

        String message = exception.getMessage();

        //then
        assertThat(message).isEqualTo("이미 입력한 숫자는 입력할수 없습니다.");
    }

    @Test
    void validUserInputZero() {
        //given
        User user = new User();
        String userInput = "012";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user.validUserInput(userInput);
        });

        String message = exception.getMessage();

        //then
        assertThat(message).isEqualTo("0은 입력할수 없습니다.");
    }

    @Test
    void validUserInputSpace() {
        //given
        User user = new User();
        String userInput = "  1";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user.validUserInput(userInput);
        });

        String message = exception.getMessage();

        //then
        assertThat(message).isEqualTo("공백은 입력할수 없습니다.");
    }

    @Test
    void validUserInputLengthOver() {
        //given
        User user = new User();
        String userInput = "1234";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user.validUserInput(userInput);
        });

        String message = exception.getMessage();

        //then
        assertThat(message).isEqualTo("숫자는 세자리 수만 입력 가능합니다.");
    }

    @Test
    void validUserInputOk() {
        //given
        User user = new User();
        String userInput = "123";

        //when
        String validUserInput = user.validUserInput(userInput);

        //then
        assertThat(validUserInput).isEqualTo(userInput);
    }

    @Test
    void validRestartOrEndInput3() {
        //given
        User user = new User();
        String userInput = "3";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user.validRestartOrEndInput(userInput);
        });

        String message = exception.getMessage();

        //then
        assertThat(message).isEqualTo("1 또는 2 의 값만 입력이 가능합니다.");
    }

    @Test
    void validRestartOrEndInput1() {
        //given
        User user = new User();
        String userInput = "1";

        //when
        int validRestartOrEndInput = user.validRestartOrEndInput(userInput);

        //then
        assertThat(validRestartOrEndInput).isEqualTo(1);
    }

    @Test
    void validRestartOrEndInput2() {
        //given
        User user = new User();
        String userInput = "2";

        //when
        int validRestartOrEndInput = user.validRestartOrEndInput(userInput);

        //then
        assertThat(validRestartOrEndInput).isEqualTo(2);
    }

    @Test
    void countBall() {
        //given
        BaseBallGame baseBallGame = new BaseBallGame();
        List<Integer> userInputArr = List.of(1, 2, 3);
        List<Integer> computerRandomNumbers = List.of(4, 5, 6);

        //when
        int countBall = baseBallGame.countBall(userInputArr, computerRandomNumbers);

        //then
        assertThat(countBall).isEqualTo(0);

    }

    @Test
    void countStrike() {
        //given
        BaseBallGame baseBallGame = new BaseBallGame();
        List<Integer> userInputArr = List.of(1, 2, 3);
        List<Integer> computerRandomNumbers = List.of(1, 2, 4);

        //when
        int countStrike = baseBallGame.countStrike(userInputArr, computerRandomNumbers);

        //then
        assertThat(countStrike).isEqualTo(2);
    }

    @Test
    void printStartGame() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BaseBallGame baseBallGame = new BaseBallGame();

        //when
        baseBallGame.printStartGameMessage();

        //then
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    void printUserInputMessage() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BaseBallGame baseBallGame = new BaseBallGame();

        //when
        baseBallGame.printUserInputMessage();

        //then
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo("숫자를 입력해주세요  :  ".trim());
    }

    @Test
    void printUserWinMessage() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BaseBallGame baseBallGame = new BaseBallGame();

        //when
        baseBallGame.printUserWinMessage();

        //then
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료".trim());
    }

    @Test
    void printRestartOrStopMessage() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BaseBallGame baseBallGame = new BaseBallGame();

        //when
        baseBallGame.printRestartOrStopMessage();

        //then
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.".trim());
    }

    @RepeatedTest(10)
    void makeHintMessageWithBallAndStrike() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BaseBallGame baseBallGame = new BaseBallGame();
        int ballCount = (int) ((Math.random() * 10000) % 10);
        int strikeCount = (int) ((Math.random() * 10000) % 10);
        if (ballCount == 0) {
            ballCount = 1;
        }

        if (strikeCount == 0) {
            strikeCount = 1;
        }

        //when
        baseBallGame.makeHintAndPrint(ballCount, strikeCount);

        //then
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(ballCount + "볼 " + strikeCount + "스트라이크".trim());
    }

    @Test
    void makeHintMessageNothing() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BaseBallGame baseBallGame = new BaseBallGame();
        int ballCount = 0;
        int strikeCount = 0;

        //when
        baseBallGame.makeHintAndPrint(ballCount, strikeCount);

        //then
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo("낫싱".trim());
    }

    @RepeatedTest(10)
    void makeHintMessageWithBall() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BaseBallGame baseBallGame = new BaseBallGame();
        int ballCount = (int) ((Math.random() * 10000) % 10);
        if (ballCount == 0) {
            ballCount = 1;
        }
        int strikeCount = 0;
        //when
        baseBallGame.makeHintAndPrint(ballCount, strikeCount);

        //then
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(ballCount + "볼".trim());
    }

    @RepeatedTest(10)
    void makeHintMessageWithStrike() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BaseBallGame baseBallGame = new BaseBallGame();
        int ballCount = 0;
        int strikeCount = (int) ((Math.random() * 10000) % 10);
        if (strikeCount == 0) {
            strikeCount = 1;
        }

        //when
        baseBallGame.makeHintAndPrint(ballCount, strikeCount);

        //then
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(strikeCount + "스트라이크".trim());
    }
}
