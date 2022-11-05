package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserNumberTest {
    @Test
    void 입력값이_네_자리_이상이면_예외_발생() throws NoSuchMethodException, InvocationTargetException {
        // given
        UserNumber userNumber = new UserNumber();
        Method method = userNumber.getClass().getDeclaredMethod("checkUserInputLength", List.class);
        method.setAccessible(true);

        String number = "1234";
        List<Character> numberList = number.chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());


        // when
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> method.invoke(userNumber, numberList));

        // then
        assertThat(exception.getCause().getMessage()).isEqualTo("입력값의 길이가 3이 아닙니다.");
    }

    @Test
    void 입력값이_두_자리_이하이면_예외_발생() throws NoSuchMethodException, InvocationTargetException {
        // given
        UserNumber userNumber = new UserNumber();
        Method method = userNumber.getClass().getDeclaredMethod("checkUserInputLength", List.class);
        method.setAccessible(true);

        String number = "12";
        List<Character> numberList = number.chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());


        // when
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> method.invoke(userNumber, numberList));

        // then
        assertThat(exception.getCause().getMessage()).isEqualTo("입력값의 길이가 3이 아닙니다.");
    }

    @Test
    void 입력값_사이에_1부터_9사이의_숫자가_아니면_예외_발생() throws NoSuchMethodException, InvocationTargetException {
        // given
        UserNumber userNumber = new UserNumber();
        Method method = userNumber.getClass().getDeclaredMethod("checkInputIsNumber", List.class);
        method.setAccessible(true);

        List<Character> numberList1 = "1;3".chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());
        List<Character> numberList2 = "ㄱㄴ4".chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());
        List<Character> numberList3 = "906".chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());

        // when
        InvocationTargetException exception1 = assertThrows(InvocationTargetException.class, () -> method.invoke(userNumber, numberList1));
        InvocationTargetException exception2 = assertThrows(InvocationTargetException.class, () -> method.invoke(userNumber, numberList2));
        InvocationTargetException exception3 = assertThrows(InvocationTargetException.class, () -> method.invoke(userNumber, numberList3));

        // then
        assertThat(exception1.getCause().getMessage()).isEqualTo("입력값 사이에 1부터 9사이의 숫자가 아닌 문자가 존재합니다.");
        assertThat(exception2.getCause().getMessage()).isEqualTo("입력값 사이에 1부터 9사이의 숫자가 아닌 문자가 존재합니다.");
        assertThat(exception3.getCause().getMessage()).isEqualTo("입력값 사이에 1부터 9사이의 숫자가 아닌 문자가 존재합니다.");
    }

    @Test
    void 중복된_값이_존재하면_예외_발생() throws NoSuchMethodException, InvocationTargetException {
        // given
        UserNumber userNumber = new UserNumber();
        Method method = userNumber.getClass().getDeclaredMethod("checkDuplicateValue", List.class);
        method.setAccessible(true);

        List<Character> numberList1 = "113".chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());
        List<Character> numberList2 = "499".chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());
        List<Character> numberList3 = "555".chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());

        // when
        InvocationTargetException exception1 = assertThrows(InvocationTargetException.class, () -> method.invoke(userNumber, numberList1));
        InvocationTargetException exception2 = assertThrows(InvocationTargetException.class, () -> method.invoke(userNumber, numberList2));
        InvocationTargetException exception3 = assertThrows(InvocationTargetException.class, () -> method.invoke(userNumber, numberList3));

        // then
        assertThat(exception1.getCause().getMessage()).isEqualTo("입력값 사이에 중복된 값이 존재합니다.");
        assertThat(exception2.getCause().getMessage()).isEqualTo("입력값 사이에 중복된 값이 존재합니다.");
        assertThat(exception3.getCause().getMessage()).isEqualTo("입력값 사이에 중복된 값이 존재합니다.");
    }

    @Test
    void 정상적인_사용자_입력값_테스트() throws NoSuchMethodException, InvocationTargetException {
        // given
        UserNumber userNumber = new UserNumber();
        Method method = userNumber.getClass().getDeclaredMethod("userNumberValidator", List.class);
        method.setAccessible(true);

        List<Character> numberList1 = "123".chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());
        List<Character> numberList2 = "734".chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());
        List<Character> numberList3 = "891".chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());

        // then
        Assertions.assertDoesNotThrow(() -> method.invoke(userNumber, numberList1));
        Assertions.assertDoesNotThrow(() -> method.invoke(userNumber, numberList2));
        Assertions.assertDoesNotThrow(() -> method.invoke(userNumber, numberList3));
    }

    @Test
    void 생성자_입력을_통한_리스트_생성_테스트() {
        // given
        UserNumber userNumber = new UserNumber("123");

        // when
        List<Character> list = Arrays.asList('1', '2', '3');

        // then
        assertThat(userNumber.getNumberList()).isEqualTo(list);
    }

}
