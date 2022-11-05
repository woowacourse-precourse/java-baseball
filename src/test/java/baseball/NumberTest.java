package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

public class NumberTest {
    Number number = new Number();

    @Test
    void boolean_세자리수_이상_입력_받았을_경우_오류_출력()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Number.class.getDeclaredMethod("isThreeDigits", String.class);
        method.setAccessible(true);

        String input = "1342";
        boolean expeted = false;

        boolean result = (boolean) method.invoke(number, input);
        assertThat(result).isEqualTo(expeted);
    }
}
