package baseball.model;

import baseball.domain.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    private final Computer computer = new Computer();

    @Nested
    @DisplayName("addUniqueString 메소드는")
    class addUniqueString_test {
        @Nested
        @DisplayName("리스트와 리스트에 이미 포함된 문자열을 입력하였을 때")
        class Context_with_list_and_contained_string {
            @Test
            @DisplayName("리스트에 해당 문자열을 add하지 않는다.")
            void it_does_not_add_the_string_into_list() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
                Method method = computer.getClass().getDeclaredMethod("addUniqueString", List.class, String.class);
                method.setAccessible(true);
                List<String> list = new ArrayList<>(List.of("1", "2", "3"));
                String containedString = "1";
                int listSize = list.size();

                method.invoke(computer, list, containedString);
                method.invoke(computer, list, containedString);

                assertThat(list.size()).isEqualTo(listSize);
            }
        }

        @Nested
        @DisplayName("리스트와 리스트에 포함되지 않은 문자열을 입력하였을 때")
        class Context_with_list_and_new_string {
            @Test
            @DisplayName("리스트에 해당 문자열을 add한다.")
            void it_adds_the_string_into_list() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
                Method method = computer.getClass().getDeclaredMethod("addUniqueString", List.class, String.class);
                method.setAccessible(true);
                List<String> list = new ArrayList<>(List.of("1", "2", "3"));
                String newString = "4";

                method.invoke(computer, list, newString);

                assertThat(list.contains(newString)).isTrue();
            }
        }
    }

    @Test
    @DisplayName("createRandomNumber 메소드가 String 숫자 하나를 반환하는지 확인")
    void createRandomNumber_list() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = computer.getClass().getDeclaredMethod("createRandomNumber");
        method.setAccessible(true);
        String numberRegularExpression = "\\d";

        String randomNumber = (String) method.invoke(computer);

        assertThat(randomNumber.matches(numberRegularExpression)).isTrue();
    }

    @Test
    @DisplayName("createRandomNumberInLength 메소드에 3을 입력하였을 때 String의 중복이 없는 세 자리 숫자를 반환하는지 확인")
    void createRandomNumberInLength_list() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = computer.getClass().getDeclaredMethod("createRandomNumberInLength", int.class);
        method.setAccessible(true);
        int lengthOfThree = 3;
        String threeNumberRegularExpression = "\\d{3}";

        String randomNumber = (String) method.invoke(computer, lengthOfThree);

        assertThat(randomNumber.matches(threeNumberRegularExpression)).isTrue();
        assertThat(isContainingDuplication(randomNumber)).isFalse();
    }

    @Test
    @DisplayName("createRandomBall 메소드가 Ball 객체를 반환하는지 확인")
    void createRandomBall_list() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = computer.getClass().getDeclaredMethod("createRandomBall");
        method.setAccessible(true);

        Ball randomNumber = (Ball) method.invoke(computer);

        assertThat(randomNumber).isInstanceOf(Ball.class);
    }

    @Test
    @DisplayName("createRandomBall 메소드가 서로 다른 Ball 객체를 반환하는지 확인")
    void createRandomBall_twice_list() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = computer.getClass().getDeclaredMethod("createRandomBall");
        method.setAccessible(true);

        Ball randomNumber = (Ball) method.invoke(computer);
        Ball otherRandomNumber = (Ball) method.invoke(computer);

        assertThat(randomNumber.toString()).isNotEqualTo(otherRandomNumber.toString());
    }

    private boolean isContainingDuplication(String number) {
        return number.length() != number.chars()
                .distinct()
                .count();
    }
}