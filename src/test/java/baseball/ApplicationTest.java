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
import static org.assertj.core.api.Assertions.*;

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
    void 사용자가_잘못된값_입력시_예외() {
        Computer computer = appConfig.computer();
        assertThatThrownBy(() -> computer.storeCorrectResult("abc", computer.createOtherNumber()))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> computer.storeCorrectResult("99", computer.createOtherNumber()))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> computer.storeCorrectResult("1000", computer.createOtherNumber()))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> computer.storeCorrectResult("122", computer.createOtherNumber()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_볼_스트라이크_낫싱_출력() {
        Computer computer = appConfig.computer();
        String nothing = computer.storeCorrectResult("123", List.of(4, 5, 6));
        String oneBall = computer.storeCorrectResult("123", List.of(3,4,5));
        String oneStrike = computer.storeCorrectResult("123", List.of(1,4,5));

        assertThat(nothing).isEqualTo("낫싱");
        assertThat(oneBall).isEqualTo("1볼");
        assertThat(oneStrike).isEqualTo("1스트라이크");
    }

    @Test
    void 재시작_종료_문구_출력() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Manager manager = appConfig.manager();
        manager.printRetryOrCloseProgram();

        assertThat("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\r\n").isEqualTo(byteArrayOutputStream.toString());
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
