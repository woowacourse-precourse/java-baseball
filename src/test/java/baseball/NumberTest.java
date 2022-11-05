package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

public class NumberTest {
    Number number = new Number();

    @Test
    void boolean_세자리수_이상_입력_받았을_경우_false_반환()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Number.class.getDeclaredMethod("isThreeDigits", String.class);
        method.setAccessible(true);

        String input = "1342";
        boolean expected = false;

        boolean result = (boolean) method.invoke(number, input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void boolean_입력받은_숫자가_숫자가_아닌_경우_false_반환()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Number.class.getDeclaredMethod("isNumber", String.class);
        method.setAccessible(true);

        String input = "13ㄱ2";
        boolean expected = false;

        boolean result = (boolean) method.invoke(number, input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void boolean_중복된_숫자를_입력받은_경우_false_반환()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Number.class.getDeclaredMethod("isNotDuplicate", String.class);
        method.setAccessible(true);

        String input = "133";
        boolean expected = false;

        boolean result = (boolean) method.invoke(number, input);
        assertThat(result).isEqualTo(expected);
    }
}
