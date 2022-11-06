package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
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

    @Test
    void 무작위로_선택한_숫자가_이미_선택했던_숫자인지의_검증_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        //given
        ComputerNumber computerNumber = new ComputerNumber();
        Method method = computerNumber.getClass().getDeclaredMethod("checkListAlreadyContainNumber", Character.class);
        method.setAccessible(true);

        Field fld = computerNumber.getClass().getDeclaredField("numberList");
        fld.setAccessible(true);
        fld.set(computerNumber, Arrays.asList('1', '2'));

        //when
        Character tempNumber1 = '1';
        Character tempNumber2 = '3';

        //then
        Assertions.assertThat(method.invoke(computerNumber, tempNumber1)).isEqualTo(true);
        Assertions.assertThat(method.invoke(computerNumber, tempNumber2)).isEqualTo(false);
    }

    @Test
    void 생성자_호출을_통해_생성한_무작위_값_검증_테스트() {
        //given
        ComputerNumber computerNumber = new ComputerNumber();

        //when
        List<Character> numberList = computerNumber.getNumberList();

        //then
        Assertions.assertThat(numberList.size()).isEqualTo(3);
    }
}
