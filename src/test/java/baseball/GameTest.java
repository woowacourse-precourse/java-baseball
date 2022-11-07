package baseball;


import baseball.datamodel.ComputerNumber;
import baseball.datamodel.UserNumber;
import baseball.system.GameProgram;
import baseball.util.CalculateScore;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

public class GameTest extends NsTest {
    private final GameProgram gameTest = new GameProgram();
    private final ComputerNumber com = new ComputerNumber();
    private final UserNumber user = new UserNumber();
    private final CalculateScore cal = new CalculateScore();

    @Test
    void scoreCounter_게임_계산_기능() {
        Method counter = null;
        try {
            counter = gameTest.getClass().getDeclaredMethod("scoreCounter", int.class);
            counter.setAccessible(true);
            counter.invoke(gameTest, 1);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Field result = null;
        try {
            result = gameTest.getClass().getDeclaredField("strike");
            result.setAccessible(true);
            int value = (int)result.get(gameTest);

            assertThat(value).isEqualTo(1);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void gameContinue_게임_진행_숫자_입력_받음() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void ComputerNumber_랜덤_숫자_생성_반환() {
        com.makeNumber();
        List<Integer> list = com.getNumbers();
        assertThat(list.get(2)).isNotNull();
    }

    @Test
    void UserNumber_사용자_숫자_연속_확인() {
        assertThatThrownBy(() -> user.checkNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void UserNumber_사용자_숫자_범위_확인() {
        assertThatThrownBy(() -> user.checkNumber("120"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void UserNumber_사용자_숫자_중복_확인() {
        assertThatThrownBy(() -> user.checkNumber("122"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void UserNumber_사용자_숫자_반환() {
        user.checkNumber("123");
        List<Integer> list = user.getNumbers();
        assertThat(list.get(2)).isNotNull();
    }

    @Test
    void CalculateScore_숫자_받아_점수_계산_strike() {
        List<Integer> list = Arrays.asList(1,2,3);
        cal.setComputerNumber(list);
        int result = cal.compareNumber(1,0);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void CalculateScore_숫자_받아_점수_계산_ball() {
        List<Integer> list = Arrays.asList(1,2,3);
        cal.setComputerNumber(list);
        int result = cal.compareNumber(1,2);

        assertThat(result).isEqualTo(2);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


}
