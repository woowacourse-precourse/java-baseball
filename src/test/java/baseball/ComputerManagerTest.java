package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerManagerTest {
    private static ComputerManager computerManager;
    private static List<Integer> numbers;

    @BeforeAll
    static void init() throws NoSuchFieldException, IllegalAccessException {
        computerManager = new ComputerManager();
        computerManager.generateRandomNumber();

        Field computerNumbers = computerManager.getClass().getDeclaredField("computerNumbers");
        computerNumbers.setAccessible(true);

        numbers = (List<Integer>) computerNumbers.get(computerManager);
    }

    @Test
    void generateRandomNumber_랜덤_수_생성_길이_체크_및_리스트_반환_체크() {
        assertThat(3).isEqualTo(numbers.size());
    }

    @Test
    void compareWithUserNumber_3스트라이크_테스트() {
        StringBuilder answer = new StringBuilder();

        for (Integer num : numbers) {
            answer.append(num);
        }

        assertThat(computerManager.compareWithUserNumber(answer.toString())).isEqualTo("3스트라이크");
    }

    @Test
    void compareWithUserNumber_볼_테스트() {
        StringBuilder answer = new StringBuilder();

        for (Integer num : numbers) {
            answer.append(num);
        }

        answer.deleteCharAt(2);
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                answer.append(randomNumber);
                break;
            }
        }

        assertThat(computerManager.compareWithUserNumber(answer.toString())).isEqualTo("2스트라이크");
    }

    @Test
    void compareWithUserNumber_스트라이크_볼_테스트() {
        StringBuilder answer = new StringBuilder();

        for (Integer num : numbers) {
            answer.append(num);
        }

        char temp = answer.charAt(1);
        answer.deleteCharAt(1);
        answer.append(temp);

        assertThat(computerManager.compareWithUserNumber(answer.toString())).isEqualTo("2볼 1스트라이크");
    }

}