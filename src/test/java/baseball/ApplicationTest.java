package baseball;

import baseball.appconfig.AppConfig;
import baseball.computer.Computer;
import baseball.manager.Manager;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    static AppConfig appConfig = new AppConfig();

    @Test
    void 게임시작_문구_출력() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Manager manager = appConfig.manager();
        manager.printGameStart();

        assertThat("숫자 야구 게임을 시작합니다.\r\n").isEqualTo(byteArrayOutputStream.toString());
    }

    @Test
    void 컴퓨터_임의의수_3개생성() {
        Computer computer = appConfig.computer();
        List<Integer> otherNumbers = computer.createOtherNumber();

        assertThat(otherNumbers).allSatisfy(otherNumber ->
                assertThat(otherNumber).isNotNull().isBetween(1, 9));
        assertThat(otherNumbers.get(0)).isNotEqualTo(otherNumbers.get(1));
        assertThat(otherNumbers.get(0)).isNotEqualTo(otherNumbers.get(2));
        assertThat(otherNumbers.get(1)).isNotEqualTo(otherNumbers.get(2));
    }

    @Test
    void 숫자입력_문구_출력() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Manager manager = appConfig.manager();
        manager.printInputGameValue();

        assertThat("숫자를 입력해주세요 : \r\n").isEqualTo(byteArrayOutputStream.toString());
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
}
