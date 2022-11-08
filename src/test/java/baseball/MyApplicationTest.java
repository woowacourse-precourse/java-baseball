package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyApplicationTest extends NsTest {
    Application application = new Application();

    @Test
    void 랜덤_값이_유효한지()
    {
        try {
            Method getRandomNum = application.getClass().getDeclaredMethod("getRandomNum");
            getRandomNum.setAccessible(true);

            String randomNum = (String) getRandomNum.invoke(application);
            assertThat(randomNum.length()).isEqualTo(3);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void 입력_값이_유효하지_않을_경우()
    {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> {Application.checkNum("311");});

        String expectedMessage = "Invalid Num";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage).contains(expectedMessage);
    }

    @Test
    void 두_수_비교하는_메서드_확인()
    {
        try {
            Method getResult = application.getClass().getDeclaredMethod("getResult", String.class, String.class);
            getResult.setAccessible(true);

            String result = (String) getResult.invoke(application, "143", "134");
            assertThat(result).isEqualTo("2볼 1스트라이크");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
