package baseball;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @Test
    void generateAnswer_올바른_생성_확인() {
        Computer computer = Computer.generateAnswer();
        try {
            Field field = computer.getClass().getDeclaredField("answer");
            field.setAccessible(true);
            Numbers answer = (Numbers) field.get(computer);
            boolean result = true;
            assertThat(result).isEqualTo(answer.validation());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
