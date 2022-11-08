package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.lang.model.type.ArrayType;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Nested
    class ValidCheckTest {
        @Test
        void testExceptionNumber() {
            HashMap<Integer, Integer> dummyHashmap = new HashMap<>();
            dummyHashmap.put(1,1);
            dummyHashmap.put(2,2);
            dummyHashmap.put(3,3);
            assertThatThrownBy(()-> ValidCheck.checkExceptionNumber("1232", dummyHashmap))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        void testExceptionNumber2() {
            HashMap<Integer, Integer> dummyHashmap = new HashMap<>();
            dummyHashmap.put(1,1);
            dummyHashmap.put(2,2);
            dummyHashmap.put(2,2);
            assertThatThrownBy(()-> ValidCheck.checkExceptionNumber("122", dummyHashmap))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        void testExceptionNumber3() {
            HashMap<Integer, Integer> dummyHashmap = new HashMap<>();
            dummyHashmap.put(1,1);
            dummyHashmap.put(2,2);
            dummyHashmap.put(3,3);
            assertThat(ValidCheck.checkExceptionNumber("123", dummyHashmap)).isNull();
        }
    }
    @Nested
    class GameManagerTest {
        @Test
        void scanNumber() {
            int result = 0;
            String input = "123";
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            HashMap<Integer,Integer> InputNumberMap = GameManager.scanNumber();
            HashMap<Integer,Integer> expectResult = new HashMap<>();
            expectResult.put(1,1);
            expectResult.put(2,2);
            expectResult.put(3,3);
            assertThat(InputNumberMap).isEqualTo(expectResult);
        }
        @Test
        void judgeNumber() {
            GameManager manager = new GameManager();
            manager.init();
            String input = "123";
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            HashMap<Integer,Integer> InputNumberMap = manager.scanNumber();
            HashMap<Character, Integer> result = manager.judgeResult();
            assertThat(result).containsKeys('S','B','O');
            ArrayList<Integer> numArray = new ArrayList(result.values());
            assertThat(numArray.stream().mapToInt(Integer::intValue).sum()).isEqualTo(3);
        }
    }
    @Nested
    class ComputerTest {
        @Test
        void generatingNumber() {
            int result = 0;
            HashMap<Integer,Integer> RandomNumberMap = Computer.generateRandomNumber();
            assertThat(RandomNumberMap).hasSize(3);
            assertThat(RandomNumberMap).containsValues(1,2,3);
            assertThat(RandomNumberMap).doesNotContainKey(0);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
