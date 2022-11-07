package baseball;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballPlayTest {
    @Test
    @Description("컴퓨터가 생성한 숫자를 사용자의 입력값으로 넣었을 때 스트라이크 3이 나오면 성공이다.")
    void 사용자의_스윙_결과를_확인한다() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        // given
        BaseballPlay baseballPlay = new BaseballPlay();

        Field field = baseballPlay.getClass().getDeclaredField("swingResult");
        field.setAccessible(true);
        Map<Swing, Integer> testSwingResult = (Map<Swing, Integer>) field.get(baseballPlay);

        for (int i = 0; i < Swing.values().length; i++) {
            testSwingResult.put(Swing.values()[i], 0);
        }

        PlayerNumber playerNumbers = new PlayerNumber(baseballPlay.computerNumbers);

        // when
        Method testPlaySwing = baseballPlay.getClass().getDeclaredMethod("compareWithComputerNumber", PlayerNumber.class);
        testPlaySwing.setAccessible(true);
        testPlaySwing.invoke(baseballPlay, playerNumbers);

        // then
        assertThat(testSwingResult.get(Swing.STRIKE)).isEqualTo(3);
    }
}