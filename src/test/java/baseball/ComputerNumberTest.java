package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

class ComputerNumberTest {
    @Test
    void 컴퓨터가_생성한_숫자의_길이_검증_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        ComputerNumber computerNumber = new ComputerNumber();
        Method method = computerNumber.getClass().getDeclaredMethod("checkListLength", List.class);
        method.setAccessible(true);

        //when
        List<Character> list1 = Arrays.asList('1', '2');
        List<Character> list2 = Arrays.asList('1', '2', '3');

        //then
        Assertions.assertThat(method.invoke(computerNumber, list1)).isEqualTo(true);
        Assertions.assertThat(method.invoke(computerNumber, list2)).isEqualTo(false);
    }
}
