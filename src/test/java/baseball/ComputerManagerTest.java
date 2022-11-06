package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerManagerTest {
    private static ComputerManager computerManager;

    @BeforeAll
    static void init(){
        computerManager = new ComputerManager();
    }

    @Test
    void generateRandomNumber_랜덤_수_생성_길이_체크_및_리스트_반환_체크() throws NoSuchFieldException, IllegalAccessException {
        computerManager.generateRandomNumber();
        Field computerNumbers = computerManager.getClass().getDeclaredField("computerNumbers");
        computerNumbers.setAccessible(true);

        List<Integer> numbers = (List<Integer>) computerNumbers.get(computerManager);
        assertThat(3).isEqualTo(numbers.size());
    }

}